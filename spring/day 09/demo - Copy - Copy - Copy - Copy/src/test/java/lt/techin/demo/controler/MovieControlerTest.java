package lt.techin.demo.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.techin.demo.model.Movie;
import lt.techin.demo.security.SecurityConfig;
import lt.techin.demo.service.MovieService;
import org.hamcrest.Matchers;
import org.hibernate.jdbc.Expectation;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = MovieController.class)

@Import(SecurityConfig.class)
public class MovieControlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MovieService movieService;

    @Test
    @WithMockUser
    void getMovies_whenFindAll_thenReturnAllAnd200() throws Exception {
        Movie movie1 = new Movie("Food for Thought: Essays and Ruminations",
                "Alton Brown",
                List.of(),
                List.of());
        Movie movie2 = new Movie("The Time Traveller's Guide to Medieval England: A Handbook for Visitors to the Fourteenth Century",
                "Ian Mortimer",
                List.of(),
                List.of());
        List<Movie> movies = List.of(movie1, movie2);

        given(movieService.findAllMovies()).willReturn(movies);

        mockMvc.perform(MockMvcRequestBuilders.get("/movies"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))

                // Check first book's regular fields
                // Testuojame ar id laukas egzistuoja; žinoma, jis nėra inkrementuojamas, nes nėra
                // sąsajos su duomenų baze
                .andExpect(jsonPath("[0].id").exists())
                .andExpect(jsonPath("[0].title").value("Food for Thought: Essays and Ruminations"))
                .andExpect(jsonPath("[0].director").value("Alton Brown"))

                .andExpect(jsonPath("[1].id").exists())
                .andExpect(jsonPath("[1].title").value("The Time Traveller's Guide to Medieval England: A Handbook for Visitors to the Fourteenth Century"))
                .andExpect(jsonPath("[1].director").value("Ian Mortimer"));
        Mockito.verify(movieService, times(1)).findAllMovies();
    }

    @Test
    @WithMockUser(authorities = "ROLE_USER")
    void getMovies_whenUserGetMovies_thenReturnAllAnd200() throws Exception {
        List<Movie> movies = List.of();

        given(movieService.findAllMovies()).willReturn(movies);
        given(movieService.findAllMovies()).willReturn(movies);
        mockMvc.perform(MockMvcRequestBuilders.get("/movies"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(0));

        Mockito.verify(movieService, times(1)).findAllMovies();
    }

    @Test
    @WithAnonymousUser
    void getMovies_whenUnauthenticatedGetMovies_thenReturnAllAnd200() throws Exception {
        List<Movie> movies = List.of();

        given(movieService.findAllMovies()).willReturn(movies);
        given(movieService.findAllMovies()).willReturn(movies);
        mockMvc.perform(MockMvcRequestBuilders.get("/movies"))
                // then
                .andExpect(status().isUnauthorized());


        Mockito.verify(movieService, times(0)).findAllMovies();
    }

    @Test
    @WithMockUser(authorities = "ROLE_USER")
    void getMovie_whenFindAll_thenReturnAllAnd200() throws Exception {
        Movie movie1 = new Movie("Food for Thought: Essays and Ruminations",
                "Alton Brown",
                List.of(),
                List.of());
        Movie movie2 = new Movie("The Time Traveller's Guide to Medieval England: A Handbook for Visitors to the Fourteenth Century",
                "Ian Mortimer",
                List.of(),
                List.of());
        List<Movie> movies = List.of(movie1, movie2);

        given(movieService.existsMovieById(1)).willReturn(true);
        given(movieService.findMovie(1)).willReturn(Optional.of(movie1));

        mockMvc.perform(MockMvcRequestBuilders.get("/movies/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("title").value("Food for Thought: Essays and Ruminations"))
                .andExpect(jsonPath("director").value("Alton Brown"));
    }

    @Test
    @WithMockUser(authorities = "ROLE_USER")
    void getMovie_whenNotFound_thenReturnAllAnd200() throws Exception {
        Movie movie1 = new Movie("Food for Thought: Essays and Ruminations",
                "Alton Brown",
                List.of(),
                List.of());
        Movie movie2 = new Movie("The Time Traveller's Guide to Medieval England: A Handbook for Visitors to the Fourteenth Century",
                "Ian Mortimer",
                List.of(),
                List.of());
        List<Movie> movies = List.of(movie1, movie2);

        given(movieService.existsMovieById(3)).willReturn(false);
        given(movieService.findMovie(3)).willReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/movies/1"))
                .andExpect(status().isNotFound())
                .andExpect(content().string(""));

    }

    @Test
    @WithAnonymousUser
    void getMovie_whenUnauthenticatedGetMovies_thenReturnAllAnd200() throws Exception {
        List<Movie> movies = List.of();
        given(movieService.existsMovieById(1)).willReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/1"))

                .andExpect(status().isUnauthorized());

        Mockito.verify(movieService, times(0)).findMovie(1);
    }

    @Test
    @WithMockUser(authorities = "ROLE_ADMIN")
    void addMovie_whenAdminAddBook_thenReturnAnd201() throws Exception {

        Movie movie1 = new Movie("Foodforthoughtessaysandruminations",
                "Cattos",
                List.of(),
                List.of());

        given(movieService.saveMovie(ArgumentMatchers.any(Movie.class))).willReturn(movie1);

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movie1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("title").value("Foodforthoughtessaysandruminations"))
                .andExpect(jsonPath("director").value("Cattos"))
                .andExpect(jsonPath("screenings").isArray())
                .andExpect(jsonPath("actors").isArray());

        Mockito.verify(movieService, times(1)).saveMovie(ArgumentMatchers.any(Movie.class));
    }

    @Test
    @WithMockUser(authorities = "ROLE_ADMIN")
    void addMovie_whenAdminAddBook_Failed_thenReturnAnd201() throws Exception {

        Movie movie = new Movie("Foodforthoughtessaysandruminations",
                "Alton Brown",
                List.of(),
                List.of());

        given(movieService.saveMovie(ArgumentMatchers.any(Movie.class))).willReturn(movie);

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movie)))
                .andExpect(status().isBadRequest());
    }
}


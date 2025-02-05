package lt.techin.demo.controler;

import jakarta.validation.Valid;
import lt.techin.demo.dto.MovieDTO;
import lt.techin.demo.dto.MovieMapper;
import lt.techin.demo.model.Movie;
import lt.techin.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

  private final MovieService movieService;

  @Autowired
  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping("/movies")
  public ResponseEntity<List<MovieDTO>> getMovies() {
    return ResponseEntity.ok(MovieMapper.toMovieDTOList(movieService.findAllMovies()));
  }

  @GetMapping("/movies/{id}")
  public ResponseEntity<MovieDTO> getMovie(@PathVariable long id) {
    Optional<Movie> movieFind = movieService.findMovie(id);

    if (movieFind.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(MovieMapper.toMovieDTO(movieFind.get()));
  }

  @PostMapping("/movies")
  public ResponseEntity<?> saveMovie(@Valid @RequestBody Movie movie) {
    Movie mov = movieService.saveMuvie(movie);

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(mov.getId())
                            .toUri())
            .body(movie);
  }

  @PutMapping("/movies/{id}")
  public ResponseEntity<?> updateMovie(@PathVariable long id, @Valid @RequestBody Movie movie) {

    if (movieService.existsMovieById(id)) {
      Movie movieF = movieService.findMovie(id).get();

      movieF.setTitle(movie.getTitle());
      movieF.setDirector(movie.getDirector());

      return ResponseEntity.ok((movieService.saveMuvie(movieF)));
    }
    Movie savedMovie = movieService.saveMuvie(movie);

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .replacePath("/movie/{id}")
                            .buildAndExpand(savedMovie.getId())
                            .toUri())
            .body(movie);
  }

  @DeleteMapping("/movies/{id}")
  public ResponseEntity<?> deleteMovie(@PathVariable long id) {

    if (!movieService.existsMovieById(id)) {
      return ResponseEntity.notFound().build();
    }
    movieService.deleteMovieById(id);
    return ResponseEntity.noContent().build();
  }
}

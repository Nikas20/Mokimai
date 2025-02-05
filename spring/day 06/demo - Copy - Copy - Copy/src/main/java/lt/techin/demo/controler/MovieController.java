package lt.techin.demo.controler;

import jakarta.validation.Valid;
import lt.techin.demo.dto.MovieDTO;
import lt.techin.demo.dto.MovieMapper;
import lt.techin.demo.model.Movie;
import lt.techin.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
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
  public ResponseEntity<?> saveMovie(@Valid @RequestBody MovieDTO movieDTO) {
    Movie mov = movieService.saveMovie(MovieMapper.toMovie(movieDTO));

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(mov.getId())
                            .toUri())
            .body(MovieMapper.toMovieDTO(mov));
  }

  @PutMapping("/movies/{id}")
  public ResponseEntity<?> updateMovie(@PathVariable long id, @Valid @RequestBody MovieDTO movieDTO) {

    if (movieService.existsMovieById(id)) {
      Movie movieF = movieService.findMovie(id).get();

      MovieMapper.updateMovieFromDTO(movieF, movieDTO);

      movieService.saveMovie(movieF);

      return ResponseEntity.ok((movieService.saveMovie(movieF)));
    }
    Movie savedMovie = movieService.saveMovie(MovieMapper.toMovie(movieDTO));

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .replacePath("/movies/{id}")
                            .buildAndExpand(savedMovie.getId())
                            .toUri())
            .body(movieDTO);
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

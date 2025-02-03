package lt.techin.demo.controler;

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
  public ResponseEntity<List<Movie>> getMovies() {
    return ResponseEntity.ok(movieService.findAllMovies());
  }

  @GetMapping("/movies/{id}")
  public ResponseEntity<Movie> getMovie(@PathVariable long id) {
    Optional<Movie> movieFind = movieService.findMovie(id);

    if (movieFind.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(movieFind.get());
  }

  @PostMapping("/movies")
  public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
    if (movie.getTitle().isEmpty() || movie.getAuthor().isEmpty()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Title or author cannot be empty");
    }
    Movie mov = movieService.saveMuvie(movie);

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(mov.getId())
                            .toUri())
            .body(movie);
  }

  @PutMapping("/movie/{id}")
  public ResponseEntity<?> updateMovie(@PathVariable long id, @RequestBody Movie movie) {

    if (movie.getTitle().isEmpty() || movie.getAuthor().isEmpty()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Title or author cannot be empty");
    }

    if (movieService.existsMovieById(id)) {
      Movie movieF = movieService.findMovie(id).get();

      movieF.setTitle(movie.getTitle());
      movieF.setAuthor(movie.getAuthor());

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

  @DeleteMapping("/movie/{id}")
  public ResponseEntity<?> deleteMovie(@PathVariable long id) {

    if (!movieService.existsMovieById(id)) {
      return ResponseEntity.notFound().build();
    }
    movieService.deleteMovieById(id);
    return ResponseEntity.noContent().build();
  }
}

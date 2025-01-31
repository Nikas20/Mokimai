package com.example.Movie2.controller;


import com.example.Movie2.model.Movie;
import com.example.Movie2.service.MovieService;
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
    if (movie.getTitle().isEmpty() || movie.getDirector().isEmpty()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Title or director cannot be empty");
    }
    Movie mov = movieService.saveMovie(movie);

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(mov.getId())
                            .toUri())
            .body(movie);
  }

  // jeigu ivest id, title ir directot korio id jau buvo ji pakeis


  @PutMapping("/movies/{id}")
  public ResponseEntity<?> updateMovie(@PathVariable long id, @RequestBody Movie movie) {

    if (movie.getTitle().isEmpty() || movie.getDirector().isEmpty()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Title or director cannot be empty");
    }

    if (movieService.existsMovieById(id)) {
      Movie movieF = movieService.findMovie(id).get();

      movieF.setTitle(movie.getTitle());
      movieF.setDirector(movie.getDirector());

      return ResponseEntity.ok(movieService.saveMovie(movieF));
    }

    Movie savedMovie = movieService.saveMovie(movie);

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


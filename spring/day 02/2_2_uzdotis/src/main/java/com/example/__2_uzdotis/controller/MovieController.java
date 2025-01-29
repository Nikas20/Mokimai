package com.example.__2_uzdotis.controller;

import com.example.__2_uzdotis.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

  List<Movie> movies = new ArrayList<>(List.of(
          new Movie(0, "Catwar", "Tom")
  ));

  @GetMapping("/movies")
  public ResponseEntity<List<Movie>> getMovies() {
    return ResponseEntity.ok(movies);
  }

  @GetMapping("/movies/{id}")
  public ResponseEntity<Movie> getMovie(@PathVariable int id) {
    if (id > movies.size() - 1) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(movies.get(id));
  }

  @PostMapping("/movies")
  public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
    if (movie.getTitle().isEmpty() || movie.getDirector().isEmpty()) {
      return ResponseEntity.badRequest().build();
    }

    movies.add(movie);

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(movies.size() - 1)
                            .toUri())
            .body(movie);
  }

  @GetMapping("/movies/search")
  public ResponseEntity<Movie> getMovieByTitle(@RequestParam String title) {
    Optional<Movie> searchMovie = movies.stream()
            .filter((mov) -> mov.getTitle().contains(title))
            .findAny();
    if (searchMovie.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(searchMovie.get());
  }
}

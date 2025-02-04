package lt.techin.demo.service;

import lt.techin.demo.model.Movie;
import lt.techin.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<Movie> findAllMovies() {
    return movieRepository.findAll();
  }

  public Optional<Movie> findMovie(long id) {
    return movieRepository.findById(id);
  }

  public Movie saveMuvie(Movie movie) {
    return movieRepository.save(movie);
  }

  public boolean existsMovieById(long id) {
    return movieRepository.existsById(id);
  }

  public void deleteMovieById(long id) {
    movieRepository.deleteById(id);
  }
}

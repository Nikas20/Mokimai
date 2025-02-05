package lt.techin.demo.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
  @Id
  @GeneratedValue(strategy =
          GenerationType.IDENTITY)
  private long id;
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_movies")
  private List<Screening> screenings;
  @ManyToMany
  @JoinTable(
          name = "movies_actors",
          joinColumns = @JoinColumn(name = "id_movies"),
          inverseJoinColumns = @JoinColumn(name = "id_actors")
  )
  private List<Actor> actors;
  private String title;
  private String director;

  public Movie(String title, String director, List<Screening> screenings, List<Actor> actors) {
    this.title = title;
    this.director = director;
    this.actors = actors;
    this.screenings = screenings;
  }

  public Movie() {
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public List<Screening> getScreenings() {
    return screenings;
  }

  public void setScreenings(List<Screening> screenings) {
    this.screenings = screenings;
  }

  public List<Actor> getActors() {
    return actors;
  }

  public void setActors(List<Actor> actors) {
    this.actors = actors;
  }
}

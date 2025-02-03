package lt.techin.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

  @Id
  @GeneratedValue(strategy =
          GenerationType.IDENTITY)
  private long id;

  @OneToMany

  @JoinColumn(name = "id_movies")
  private List<Screenings> screenings;

  private String title;
  private String author;

  public Movie(String title, String author, List<Screenings> screenings) {
    this.title = title;
    this.author = author;
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

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public List<Screenings> getScreenings() {
    return screenings;
  }

  public void setScreenings(List<Screenings> screenings) {
    this.screenings = screenings;
  }
}

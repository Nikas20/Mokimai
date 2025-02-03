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

  // Kai One to many, galima uzdeti CascadeType.ALL
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_movies")
  private List<Screening> screenings;

  private String title;
  private String author;

  public Movie(String title, String author, List<Screening> screenings) {
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

  public List<Screening> getScreenings() {
    return screenings;
  }

  public void setScreenings(List<Screening> screenings) {
    this.screenings = screenings;
  }
}

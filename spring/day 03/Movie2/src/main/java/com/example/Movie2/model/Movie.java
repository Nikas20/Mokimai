package com.example.Movie2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

  @Id
  @GeneratedValue(strategy =
          GenerationType.IDENTITY)
  private long id;

  private String title;
  private String director;

  public Movie(String title, String author) {
    this.title = title;
    this.director = director;
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
}

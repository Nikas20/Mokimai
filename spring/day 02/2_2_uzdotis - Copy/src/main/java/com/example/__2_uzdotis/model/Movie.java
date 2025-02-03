package com.example.__2_uzdotis.model;

public class Movie {
  private int id;
  private String title;
  private String director;

  public Movie(int id, String title, String director) {

    this.title = title;
    this.director = director;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDirector() {
    return director;
  }
}

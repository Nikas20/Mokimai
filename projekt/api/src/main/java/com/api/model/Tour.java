package com.api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tours")
public class Tour {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;
  private String description;
  private String photo_url;
  private int duration_minutes;
  private BigDecimal price;
  private int max_participants;
  private BigDecimal average_rating;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "tours_category",
          joinColumns = @JoinColumn(name = "tour_id"),
          inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  private List<Category> category = new ArrayList<>();

  public Tour (String title, String description, String photo_url, int duration_minutes, BigDecimal price, int max_participants, BigDecimal average_rating){
    this.title = title;
    this.description = description;
    this. photo_url = photo_url;
    this.duration_minutes = duration_minutes;
    this.price = price;
    this.max_participants = max_participants;
    this.average_rating = average_rating;
  }
  public  Tour () {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPhoto_url() {
    return photo_url;
  }

  public void setPhoto_url(String photo_url) {
    this.photo_url = photo_url;
  }

  public int getDuration_minutes() {
    return duration_minutes;
  }

  public void setDuration_minutes(int duration_minutes) {
    this.duration_minutes = duration_minutes;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public int getMax_participants() {
    return max_participants;
  }

  public void setMax_participants(int max_participants) {
    this.max_participants = max_participants;
  }

  public BigDecimal getAverage_rating() {
    return average_rating;
  }

  public void setAverage_rating(BigDecimal average_rating) {
    this.average_rating = average_rating;
  }

  public List<Category> getCategory() {
    return category;
  }

  public void setCategory(List<Category> category) {
    this.category = category;
  }
}

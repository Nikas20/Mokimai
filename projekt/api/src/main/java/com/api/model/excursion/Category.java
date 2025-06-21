package com.api.model.excursion;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "category_name")
  private String categoryName;

  public Category(String categoryName){
    this.categoryName = categoryName;
  }

  public Category(String categoryName, long id) {
    this.categoryName = categoryName;
    this.id = id;
  }

  public Category(){
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}

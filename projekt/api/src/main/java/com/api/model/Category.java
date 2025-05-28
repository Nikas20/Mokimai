package com.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String categoryName;

  public Category(String categoryName){
    this.categoryName = categoryName;
  }
}

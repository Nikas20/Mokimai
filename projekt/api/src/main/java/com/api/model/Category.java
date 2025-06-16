package com.api.model;

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
}

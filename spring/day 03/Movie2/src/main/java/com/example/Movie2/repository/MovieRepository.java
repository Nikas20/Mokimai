package com.example.Movie2.repository;

import com.example.Movie2.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {



}

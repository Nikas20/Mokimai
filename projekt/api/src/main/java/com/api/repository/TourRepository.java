package com.api.repository;


import com.api.model.excursion.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {

  List<Tour> findAllById(long id);

  @Query("SELECT DISTINCT t FROM Tour t JOIN t.dates d " +
          "WHERE (:title IS NULL OR LOWER(t.title) LIKE LOWER(CONCAT('%', :title, '%'))) " +
          "AND (:date IS NULL OR d.date = :date)")
  List<Tour> searchByTitleAndDate(@Param("title") String title, @Param("date") LocalDate date);
}

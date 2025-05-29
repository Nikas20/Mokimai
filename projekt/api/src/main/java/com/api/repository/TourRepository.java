package com.api.repository;


import com.api.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {

  List<Tour> findAllById(long id);
}

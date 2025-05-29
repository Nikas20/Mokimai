package com.api.controller;

import com.api.model.Tour;
import com.api.service.TourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TourController {

  private final TourService tourService;

  public TourController(TourService tourService) {
    this.tourService = tourService;
  }

  @GetMapping("/tuor")
  public ResponseEntity<?> getAllServices(){

    List<Tour> allTuors = tourService.findAllTours();

    if(allTuors.isEmpty()){
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok().build();
  }
}

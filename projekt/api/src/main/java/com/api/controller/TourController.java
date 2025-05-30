package com.api.controller;

import com.api.dto.TourDTO.TourMapper;
import com.api.dto.TourDTO.TourResponseDTO;
import com.api.dto.TourDTO.ToutRequiestDTO;
import com.api.model.Tour;
import com.api.service.TourService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TourController {
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/tuor")
    public ResponseEntity<?> getAllServices() {
        List<Tour> allTuors = tourService.findAllTours();
        if (allTuors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(TourMapper.toTourListDTO(allTuors));
    }

    @PostMapping("/tour")
    public ResponseEntity<?> addTour(@Valid @RequestBody ToutRequiestDTO toutRequiestDTO) {
        Tour tour = new Tour();
        tour.setTitle(toutRequiestDTO.title());
        tour.setDescription(toutRequiestDTO.description());
        tour.setPhoto_url(toutRequiestDTO.photo_url());
        tour.setDuration_minutes(toutRequiestDTO.duration_minutes());
        tour.setPrice(toutRequiestDTO.price());
        TourResponseDTO newTour = TourMapper.toTourDTO(tourService.saveTour(tour));
        return ResponseEntity.status(HttpStatus.CREATED).body(newTour);
    }

    @DeleteMapping("/tour/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable long id) {
        if (!tourService.existByID(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tour not found");
        }
        tourService.deleteTourById(id);
        return ResponseEntity.noContent().build();
    }
}

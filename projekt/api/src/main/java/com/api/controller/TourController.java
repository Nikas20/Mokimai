package com.api.controller;

import com.api.dto.TourDTO.TourMapper;
import com.api.dto.TourDTO.TourResponseDTO;
import com.api.dto.TourDTO.TourRequestDTO;
import com.api.model.Tour;
import com.api.service.TourService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TourController {
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/tour")
    public ResponseEntity<?> getAllTours() {
        List<Tour> allTours = tourService.findAllTours();
        if (allTours.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(TourMapper.toTourListDTO(allTours));
    }

    @GetMapping("/tour/{id}")
    public ResponseEntity<?> getTour(@PathVariable long id) {
        Optional<Tour> tour = tourService.findByIdTour(id);

        if (tour.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tour not found");
        }

        return ResponseEntity.ok(TourMapper.toTourDTO(tour.get()));
    }

    @PostMapping("/tour")
    public ResponseEntity<?> addTour(@Valid @RequestBody TourRequestDTO tourRequestDTO) {
        Tour tour = new Tour();
        tour.setTitle(tourRequestDTO.title());
        tour.setDescription(tourRequestDTO.description());
        tour.setPhoto_url(tourRequestDTO.photo_url());
        tour.setDuration_minutes(tourRequestDTO.duration_minutes());
        tour.setPrice(tourRequestDTO.price());
        TourResponseDTO newTour = TourMapper.toTourDTO(tourService.saveTour(tour));
        return ResponseEntity.status(HttpStatus.CREATED).body(newTour);
    }

    @DeleteMapping("/tour/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable Long id) {
        if (!tourService.existByID(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tour not found");
        }

        tourService.deleteTourById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/tour/{Id}")
    public ResponseEntity<?> updateTour(@PathVariable long Id,
                                        @Valid @RequestBody TourRequestDTO tourRequestDTO) {
        if (Id < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tour ID cannot be negative");
        }

        Optional<Tour> tourOpt = tourService.findByIdTour(Id);

        if (tourOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tour not found");
        }

        Tour tourFromDB = tourOpt.get();
        Tour updatedTour = TourMapper.updateTourDTO(tourRequestDTO, tourFromDB);

        tourService.saveTour(updatedTour);

        return ResponseEntity.ok(TourMapper.toTourDTO(updatedTour));
    }


    @GetMapping("/tour/pagination")
    public ResponseEntity<Page<TourResponseDTO>> getPaginatedTours(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            @RequestParam(defaultValue = "id") String sort
    ) {
        Page<Tour> tourPage = tourService.getPaginatedTours(page, size, sort);
        Page<TourResponseDTO> dtoPage = tourPage.map(TourMapper::toTourDTO);
        return ResponseEntity.ok(dtoPage);
    }

}

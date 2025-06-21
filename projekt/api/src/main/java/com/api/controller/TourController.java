package com.api.controller;

import com.api.dto.TourDTO.TourMapper;
import com.api.dto.TourDTO.TourResponseDTO;
import com.api.dto.TourDTO.TourRequestDTO;
import com.api.model.excursion.Category;
import com.api.model.excursion.Tour;
import com.api.model.excursion.TourDate;
import com.api.service.TourService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity<?> addTour(@Valid @RequestBody TourRequestDTO dto) {
        Tour tour = new Tour();
        tour.setTitle(dto.title());
        tour.setDescription(dto.description());
        tour.setPhoto_url(dto.photo_url());
        tour.setDuration_minutes(dto.duration_minutes());
        tour.setPrice(dto.price());
        tour.setMax_participants(dto.max_participants());

        List<Category> categories = tourService.getCategoriesByIds(dto.categoryIds());
        tour.setCategories(categories);

        Tour saved = tourService.saveTourWithDates(tour, dto.dates());

        return ResponseEntity.status(HttpStatus.CREATED).body(TourMapper.toTourDTO(saved));
    }

    @DeleteMapping("/tour/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable Long id) {
        if (!tourService.existByID(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tour not found");
        }

        tourService.deleteTourById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/tour/{id}")
    public ResponseEntity<?> updateTour(@PathVariable long id,
                                        @Valid @RequestBody TourRequestDTO dto) {
        if (id < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tour ID cannot be negative");
        }

        Optional<Tour> tourOpt = tourService.findByIdTour(id);
        if (tourOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tour not found");
        }

        Tour tourFromDB = tourOpt.get();
        List<Category> categories = tourService.getCategoriesByIds(dto.categoryIds());

        Tour updatedTour = TourMapper.updateTourFromDTO(dto, tourFromDB, categories);
        Tour saved = tourService.saveTourWithDates(updatedTour, dto.dates());

        return ResponseEntity.ok(TourMapper.toTourDTO(saved));
    }


    @GetMapping("/tour/{id}/dates")
    public ResponseEntity<?> getTourDates(@PathVariable Long id) {
        if (!tourService.existByID(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tour not found");
        }

        List<TourDate> dates = tourService.getDatesByTourId(id);
        return ResponseEntity.ok(dates);
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

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = tourService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/tour/search")
    public ResponseEntity<?> searchTours(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        List<Tour> result = tourService.searchTours(title, date);
        return ResponseEntity.ok(TourMapper.toTourListDTO(result));
    }

    @GetMapping("/tour/dates")
    public ResponseEntity<?> getAllTourDates() {
        List<TourDate> allDates = tourService.findAllDates();
        return ResponseEntity.ok(allDates);
    }
}

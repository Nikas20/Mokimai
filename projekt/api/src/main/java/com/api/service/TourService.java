package com.api.service;

import com.api.model.Tour;
import com.api.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {
    private final TourRepository tourRepository;

    @Autowired

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> findAllTours() {
        return tourRepository.findAll();
    }

    public Tour saveTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public boolean existByID(long id) {
        return tourRepository.existsById(id);
    }

    public void deleteTourById(long id) {
        tourRepository.deleteById(id);
    }

    public Optional<Tour> findByIdTour(long id) {
        return tourRepository.findById(id);
    }

    public Page<Tour> getPaginatedTours(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return tourRepository.findAll(pageable);
    }
}

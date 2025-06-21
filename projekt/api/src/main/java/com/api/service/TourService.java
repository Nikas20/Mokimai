package com.api.service;

import com.api.model.excursion.Category;
import com.api.model.excursion.TourDate;
import com.api.model.excursion.Tour;
import com.api.repository.CategoryRepository;
import com.api.repository.TourDateRepository;
import com.api.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TourService {
    private final TourRepository tourRepository;
    private final TourDateRepository tourDateRepository;
    private final CategoryRepository categoryRepository;
    @Autowired

    public TourService(TourRepository tourRepository, TourDateRepository tourDateRepository,  CategoryRepository categoryRepository) {
        this.tourRepository = tourRepository;
        this.tourDateRepository = tourDateRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategoriesByIds(List<Long> categoryIds) {
        return categoryRepository.findAllById(categoryIds);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
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

    public Tour saveTourWithDates(Tour tour, List<LocalDate> dates) {
        Tour saved = tourRepository.save(tour);

        tourDateRepository.deleteByTourId(saved.getId());

        if (dates != null && !dates.isEmpty()) {
            List<TourDate> dateList = dates.stream()
                    .map(d -> new TourDate(d, saved))
                    .toList();
            tourDateRepository.saveAll(dateList);
            saved.setDates(dateList);
        }

        return saved;
    }

    public List<TourDate> getDatesByTourId(Long tourId) {
        return tourDateRepository.findByTourId(tourId);
    }

    public List<Tour> searchTours(String title, LocalDate date) {
        return tourRepository.searchByTitleAndDate(title, date);
    }

    public List<TourDate> findAllDates() {
        return tourDateRepository.findAll();
    }
}

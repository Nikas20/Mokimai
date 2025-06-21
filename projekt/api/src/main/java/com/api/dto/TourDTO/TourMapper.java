package com.api.dto.TourDTO;

import com.api.model.excursion.Category;
import com.api.model.excursion.Tour;
import com.api.model.excursion.TourDate;

import java.time.LocalDate;
import java.util.List;

public class TourMapper {

    public static TourResponseDTO toTourDTO(Tour tour) {
        List<CategoryDTO> categories = tour.getCategories().stream()
                .map(c -> new CategoryDTO(c.getId(), c.getCategoryName()))
                .toList();

        List<LocalDate> dates = tour.getDates().stream()
                .map(TourDate::getDate)
                .toList();

        return new TourResponseDTO(
                tour.getId(),
                tour.getTitle(),
                tour.getDescription(),
                tour.getPhoto_url(),
                tour.getDuration_minutes(),
                tour.getPrice(),
                tour.getMax_participants(),
                tour.getAverage_rating(),
                categories,
                dates
        );
    }

    public static List<TourResponseDTO> toTourListDTO(List<Tour> tours) {
        return tours.stream().map(TourMapper::toTourDTO).toList();
    }

    public static Tour updateTourFromDTO(TourRequestDTO dto, Tour tour, List<Category> categories) {
        tour.setTitle(dto.title());
        tour.setDescription(dto.description());
        tour.setPhoto_url(dto.photo_url());
        tour.setDuration_minutes(dto.duration_minutes());
        tour.setPrice(dto.price());
        tour.setMax_participants(dto.max_participants());
        tour.setCategories(categories);
        return tour;
    }
}

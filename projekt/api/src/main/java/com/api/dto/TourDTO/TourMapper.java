package com.api.dto.TourDTO;

import com.api.model.Tour;

import java.util.List;

public class TourMapper {

    public static TourResponseDTO
    toTourDTO(Tour tour) {
        return new TourResponseDTO
                (tour.getId(),
                        tour.getTitle(),
                        tour.getDescription(),
                        tour.getPhoto_url(),
                        tour.getDuration_minutes(),
                        tour.getPrice(),
                        tour.getMax_participants(),
                        tour.getAverage_rating());
    }

    public static List<TourResponseDTO> toTourListDTO
            (List<Tour> tour) {
        return tour.stream().map(
                        t -> new TourResponseDTO(
                                t.getId(),
                                t.getTitle(),
                                t.getDescription(),
                                t.getPhoto_url(),
                                t.getDuration_minutes(),
                                t.getPrice(),
                                t.getMax_participants(),
                                t.getAverage_rating()))
                .toList();
    }



    public static Tour updateTourDTO(TourRequestDTO tourRequestDTO, Tour tour) {
        tour.setTitle(tourRequestDTO.title());
        tour.setDescription(tourRequestDTO.description());
        tour.setPhoto_url(tourRequestDTO.photo_url());
        tour.setDuration_minutes(tourRequestDTO.duration_minutes());
        tour.setPrice(tourRequestDTO.price());

        return tour;
    }
}

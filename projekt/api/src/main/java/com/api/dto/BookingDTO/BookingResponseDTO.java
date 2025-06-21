package com.api.dto.BookingDTO;

import java.time.LocalDate;

public record BookingResponseDTO(
        Long id,
        Long userId,
        boolean confirmed,
        TourDateDTO tourDate
) {
    public record TourDateDTO(
            Long id,
            LocalDate date,
            TourDTO tour
    ) {}

    public record TourDTO(
            Long id,
            String title
    ) {}
}

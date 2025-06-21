package com.api.dto.BookingDTO;

import com.api.model.excursion.Booking;
import com.api.model.excursion.Tour;
import com.api.model.excursion.TourDate;

public class BookingMapper {
    public static BookingResponseDTO toDto(Booking booking) {
        TourDate tourDate = booking.getTourDate();
        Tour tour = tourDate.getTour(); // может быть null

        BookingResponseDTO.TourDTO tourDto = null;
        if (tour != null) {
            tourDto = new BookingResponseDTO.TourDTO(tour.getId(), tour.getTitle());
        }

        return new BookingResponseDTO(
                booking.getId(),
                booking.getUser().getId(),
                booking.isConfirmed(),
                new BookingResponseDTO.TourDateDTO(
                        tourDate.getId(),
                        tourDate.getDate(),
                        tourDto
                )
        );
    }

}

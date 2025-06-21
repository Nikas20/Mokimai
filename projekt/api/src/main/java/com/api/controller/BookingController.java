package com.api.controller;


import com.api.dto.BookingDTO.BookingMapper;
import com.api.dto.BookingDTO.BookingRequestDTO;
import com.api.model.excursion.Booking;
import com.api.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<?> bookTour(@RequestBody BookingRequestDTO dto) {
        try {
            Booking booking = bookingService.bookTour(dto.userId(), dto.tourDateId());
            return ResponseEntity.ok(BookingMapper.toDto(booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserBookings(@PathVariable Long userId) {
        var dtos = bookingService.getBookingsByUser(userId)
                .stream()
                .map(BookingMapper::toDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping
    public ResponseEntity<?> cancelBooking(@RequestParam Long userId, @RequestParam Long tourDateId) {
        bookingService.cancelBooking(userId, tourDateId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<?> confirmBooking(@PathVariable Long id) {
        Booking booking = bookingService.confirmBooking(id);
        return ResponseEntity.ok(BookingMapper.toDto(booking));
    }

    @GetMapping
    public ResponseEntity<?> getAllBookings() {
        var dtos = bookingService.getAllBookings()
                .stream()
                .map(BookingMapper::toDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}/change-date")
    public ResponseEntity<?> changeBookingDate(
            @PathVariable Long id,
            @RequestBody Map<String, Long> body) {
        try {
            Long newDateId = body.get("newDateId");
            Booking updated = bookingService.changeBookingDate(id, newDateId);
            return ResponseEntity.ok(BookingMapper.toDto(updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

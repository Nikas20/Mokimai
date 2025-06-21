package com.api.service;

import com.api.model.account.Account;
import com.api.model.excursion.Booking;
import com.api.model.excursion.TourDate;
import com.api.repository.AccountRepository;
import com.api.repository.BookingRepository;
import com.api.repository.TourDateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final AccountRepository accountRepository;
    private final TourDateRepository tourDateRepository;

    public BookingService(BookingRepository bookingRepository,
                          AccountRepository accountRepository,
                          TourDateRepository tourDateRepository) {
        this.bookingRepository = bookingRepository;
        this.accountRepository = accountRepository;
        this.tourDateRepository = tourDateRepository;
    }


    public Booking bookTour(Long userId, Long tourDateId) {
        if (bookingRepository.findByUserIdAndTourDateId(userId, tourDateId).isPresent()) {
            throw new IllegalStateException("Already booked");
        }

        Account user = accountRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        TourDate date = tourDateRepository.findById(tourDateId)
                .orElseThrow(() -> new IllegalArgumentException("Date not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setTourDate(date);
        return bookingRepository.save(booking);
    }

    public void cancelBooking(Long userId, Long tourDateId) {
        Booking booking = bookingRepository.findByUserIdAndTourDateId(userId, tourDateId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        bookingRepository.delete(booking);
    }

    public Booking confirmBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        booking.setConfirmed(true);
        return bookingRepository.save(booking);
    }


    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findAllByUserId(userId);
    }


    public List<Booking> getBookingsByTourDate(Long tourDateId) {
        return bookingRepository.findAllByTourDateId(tourDateId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking changeBookingDate(Long bookingId, Long newTourDateId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        TourDate newDate = tourDateRepository.findById(newTourDateId)
                .orElseThrow(() -> new IllegalArgumentException("New tour date not found"));

        booking.setTourDate(newDate);
        return bookingRepository.save(booking);
    }
}

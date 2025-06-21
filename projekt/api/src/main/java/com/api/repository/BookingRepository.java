package com.api.repository;

import com.api.model.excursion.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findByUserIdAndTourDateId(Long userId, Long tourDateId);

    List<Booking> findAllByUserId(Long userId);

    List<Booking> findAllByTourDateId(Long tourDateId);

}

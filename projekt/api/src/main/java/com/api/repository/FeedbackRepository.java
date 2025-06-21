package com.api.repository;

import com.api.model.excursion.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    boolean existsByUserIdAndTourId(Long userId, Long tourId);
    List<Feedback> findAllByTourId(Long tourId);
}

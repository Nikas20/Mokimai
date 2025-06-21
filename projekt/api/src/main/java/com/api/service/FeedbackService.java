package com.api.service;


import com.api.dto.FeedbackDTO.FeedbackRequestDTO;
import com.api.model.account.Account;
import com.api.model.excursion.Feedback;
import com.api.model.excursion.Tour;
import com.api.repository.AccountRepository;
import com.api.repository.FeedbackRepository;
import com.api.repository.TourRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final AccountRepository accountRepository;
    private final TourRepository tourRepository;

    public FeedbackService(FeedbackRepository feedbackRepository,
                           AccountRepository accountRepository,
                           TourRepository tourRepository) {
        this.feedbackRepository = feedbackRepository;
        this.accountRepository = accountRepository;
        this.tourRepository = tourRepository;
    }

    public Feedback leaveFeedback(FeedbackRequestDTO dto) {
        Account user = accountRepository.findById(dto.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Tour tour = tourRepository.findById(dto.tourId())
                .orElseThrow(() -> new IllegalArgumentException("Tour not found"));

        Feedback feedback = new Feedback();
        feedback.setUser(user);
        feedback.setTour(tour);
        feedback.setRating(dto.rating());
        feedback.setComment(dto.comment());

        Feedback saved = feedbackRepository.save(feedback);
        recalculateAverageRating(tour.getId());
        return saved;
    }

    public List<Feedback> getByTourId(Long tourId) {
        return feedbackRepository.findAllByTourId(tourId);
    }

    @Transactional
    public void recalculateAverageRating(Long tourId) {
        List<Feedback> feedbackList = feedbackRepository.findAllByTourId(tourId);
        if (feedbackList.isEmpty()) return;

        double avg = feedbackList.stream()
                .filter(f -> f.getRating() != null)
                .mapToInt(Feedback::getRating)
                .average()
                .orElse(0.0);

        Tour tour = tourRepository.findById(tourId).orElseThrow();
        tour.setAverage_rating(BigDecimal.valueOf(avg).setScale(2, BigDecimal.ROUND_HALF_UP));
        tourRepository.save(tour);
    }
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
}

package com.api.controller;

import com.api.dto.FeedbackDTO.FeedbackMapper;
import com.api.dto.FeedbackDTO.FeedbackRequestDTO;
import com.api.service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<?> submit(@RequestBody FeedbackRequestDTO dto) {
        try {
            var feedback = feedbackService.leaveFeedback(dto);
            return ResponseEntity.ok(FeedbackMapper.toDto(feedback));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/tour/{tourId}")
    public ResponseEntity<?> getForTour(@PathVariable Long tourId) {
        var feedbackList = feedbackService.getByTourId(tourId)
                .stream()
                .map(FeedbackMapper::toDto)
                .toList();
        return ResponseEntity.ok(feedbackList);
    }
    @GetMapping
    public ResponseEntity<?> getAllFeedbacks() {
        var feedbacks = feedbackService.getAllFeedbacks()
                .stream()
                .map(FeedbackMapper::toResponseDTO)
                .toList();
        return ResponseEntity.ok(feedbacks);
    }
}

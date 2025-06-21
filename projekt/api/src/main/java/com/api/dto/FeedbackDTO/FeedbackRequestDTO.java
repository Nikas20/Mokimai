package com.api.dto.FeedbackDTO;

public record FeedbackRequestDTO(
        Long userId,
        Long tourId,
        Integer rating,
        String comment
) {}

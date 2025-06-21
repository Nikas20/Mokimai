package com.api.dto.FeedbackDTO;

import java.time.LocalDateTime;

public record FeedbackResponseDTO(
        Long id,
        Long userId,
        String userEmail,
        Long tourId,
        Integer rating,
        String comment,
        LocalDateTime createdAt
) {}

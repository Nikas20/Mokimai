package com.api.dto.FeedbackDTO;

import java.time.LocalDateTime;

public record FeedbackAdminResponseDTO(
        Long id,
        String userEmail,
        String tourTitle,
        int rating,
        String comment,
        LocalDateTime createdAt
) {}

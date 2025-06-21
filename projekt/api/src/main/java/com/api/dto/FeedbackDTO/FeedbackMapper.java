package com.api.dto.FeedbackDTO;

import com.api.dto.FeedbackDTO.FeedbackResponseDTO;
import com.api.model.excursion.Feedback;

public class FeedbackMapper {

    public static FeedbackResponseDTO toDto(Feedback feedback) {
        return new FeedbackResponseDTO(
                feedback.getId(),
                feedback.getUser().getId(),
                feedback.getUser().getEmail(),
                feedback.getTour().getId(),
                feedback.getRating(),
                feedback.getComment(),
                feedback.getCreatedAt()
        );
    }

    public static FeedbackAdminResponseDTO toResponseDTO(Feedback feedback) {
        return new FeedbackAdminResponseDTO(
                feedback.getId(),
                feedback.getUser().getEmail(),
                feedback.getTour().getTitle(),
                feedback.getRating(),
                feedback.getComment(),
                feedback.getCreatedAt()
        );
    }
}

package com.api.dto.TourDTO;

import java.math.BigDecimal;

public record TourResponseDTO(
        long id,
        String title,
        String description,
        String photo_url,
        int duration_minutes,
        BigDecimal price,
        int max_participants,
        BigDecimal average_rating

) {

}

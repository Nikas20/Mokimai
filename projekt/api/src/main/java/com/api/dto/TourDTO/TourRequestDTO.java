package com.api.dto.TourDTO;

import java.math.BigDecimal;

public record TourRequestDTO(
        String title,
        String description,
        String photo_url,
        int duration_minutes,
        BigDecimal price
) {
}

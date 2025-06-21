package com.api.dto.TourDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record TourResponseDTO(
        long id,
        String title,
        String description,
        String photo_url,
        int duration_minutes,
        BigDecimal price,
        int max_participants,
        BigDecimal average_rating,
        List<CategoryDTO> categories,
        List<LocalDate> dates
) {}

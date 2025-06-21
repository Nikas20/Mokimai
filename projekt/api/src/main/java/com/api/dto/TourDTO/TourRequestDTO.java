package com.api.dto.TourDTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record TourRequestDTO(
        String title,
        String description,
        String photo_url,
        int duration_minutes,
        BigDecimal price,
        int max_participants,
        List<Long> categoryIds,
        @JsonFormat(pattern = "yyyy-MM-dd")
        List<LocalDate> dates
) {}

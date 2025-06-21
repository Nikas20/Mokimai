package com.api.repository;

import com.api.model.excursion.TourDate;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TourDateRepository extends JpaRepository<TourDate, Long> {

    List<TourDate> findByTourId(Long tourId);

    @Transactional
    @Modifying
    @Query("DELETE FROM TourDate d WHERE d.tour.id = :tourId")
    void deleteByTourId(@Param("tourId") Long tourId);
}

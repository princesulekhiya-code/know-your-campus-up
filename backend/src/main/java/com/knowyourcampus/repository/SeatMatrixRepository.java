package com.knowyourcampus.repository;

import com.knowyourcampus.entity.SeatMatrix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatMatrixRepository extends JpaRepository<SeatMatrix, Long> {

    List<SeatMatrix> findByCourseId(Long courseId);

    List<SeatMatrix> findByAcademicYear(String academicYear);

    @Query("SELECT s FROM SeatMatrix s WHERE s.course.id = :courseId AND s.academicYear = :academicYear")
    List<SeatMatrix> findByCourseIdAndAcademicYear(
            @Param("courseId") Long courseId,
            @Param("academicYear") String academicYear);

    Optional<SeatMatrix> findByCourseIdAndCategoryAndAcademicYear(
            Long courseId, String category, String academicYear);
}

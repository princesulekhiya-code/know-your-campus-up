package com.knowyourcampus.repository;

import com.knowyourcampus.entity.FeeStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeeStructureRepository extends JpaRepository<FeeStructure, Long> {

    List<FeeStructure> findByCourseId(Long courseId);

    List<FeeStructure> findByAcademicYear(String academicYear);

    @Query("SELECT f FROM FeeStructure f WHERE f.course.id = :courseId AND f.academicYear = :academicYear")
    Optional<FeeStructure> findByCourseIdAndAcademicYear(
            @Param("courseId") Long courseId,
            @Param("academicYear") String academicYear);
}

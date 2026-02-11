package com.knowyourcampus.repository;

import com.knowyourcampus.entity.Cutoff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CutoffRepository extends JpaRepository<Cutoff, Long> {

    List<Cutoff> findByCourseId(Long courseId);

    List<Cutoff> findByAcademicYear(String academicYear);

    List<Cutoff> findByCourseIdAndAcademicYear(Long courseId, String academicYear);

    List<Cutoff> findByCourseIdOrderByAcademicYearDesc(Long courseId);

    Cutoff findByCourseAndCategoryAndAcademicYearAndRound(com.knowyourcampus.entity.Course course, String category,
            String academicYear, String round);
}

package com.knowyourcampus.repository;

import com.knowyourcampus.entity.FeeStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeStructureRepository extends JpaRepository<FeeStructure, Long> {

    List<FeeStructure> findByCourseId(Long courseId);

    List<FeeStructure> findByAcademicYear(String academicYear);

    List<FeeStructure> findByCourseAndAcademicYear(
            com.knowyourcampus.entity.Course course, String academicYear);
}

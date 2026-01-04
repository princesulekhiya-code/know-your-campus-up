package com.knowyourcampus.repository;

import com.knowyourcampus.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByCollegeId(Long collegeId);

    List<Course> findByDegree(String degree);

    List<Course> findByActive(Boolean active);

    @Query("SELECT c FROM Course c WHERE c.college.id = :collegeId AND c.active = true")
    List<Course> findActiveByCollegeId(@Param("collegeId") Long collegeId);

    @Query("SELECT c FROM Course c WHERE " +
            "LOWER(c.name) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(c.specialization) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Course> searchCourses(@Param("query") String query);
}

package com.knowyourcampus.repository;

import com.knowyourcampus.entity.StudentLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StudentLeadRepository extends JpaRepository<StudentLead, Long> {

    List<StudentLead> findByStatus(String status);

    List<StudentLead> findByCollegeId(Long collegeId);

    List<StudentLead> findByLeadSource(String leadSource);

    @Query("SELECT s FROM StudentLead s WHERE s.createdAt >= :startDate ORDER BY s.createdAt DESC")
    List<StudentLead> findRecentLeads(@Param("startDate") LocalDateTime startDate);

    @Query("SELECT COUNT(s) FROM StudentLead s WHERE s.collegeId = :collegeId")
    Long countByCollegeId(@Param("collegeId") Long collegeId);

    @Query("SELECT s.status, COUNT(s) FROM StudentLead s GROUP BY s.status")
    List<Object[]> countByStatus();

    @Query("SELECT s FROM StudentLead s ORDER BY s.createdAt DESC")
    List<StudentLead> findAllOrderByCreatedAtDesc();
}

package com.knowyourcampus.repository;

import com.knowyourcampus.entity.PageTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PageTrackingRepository extends JpaRepository<PageTracking, Long> {

    List<PageTracking> findByCollegeId(Long collegeId);

    @Query("SELECT COUNT(p) FROM PageTracking p WHERE p.collegeId = :collegeId")
    Long countByCollegeId(@Param("collegeId") Long collegeId);

    @Query("SELECT p.collegeId, COUNT(p) FROM PageTracking p WHERE p.collegeId IS NOT NULL GROUP BY p.collegeId ORDER BY COUNT(p) DESC")
    List<Object[]> findMostViewedColleges();

    @Query("SELECT p FROM PageTracking p WHERE p.visitedAt >= :startDate ORDER BY p.visitedAt DESC")
    List<PageTracking> findRecentVisits(@Param("startDate") LocalDateTime startDate);

    @Query("SELECT COUNT(p) FROM PageTracking p WHERE p.visitedAt >= :startDate")
    Long countVisitsSince(@Param("startDate") LocalDateTime startDate);
}

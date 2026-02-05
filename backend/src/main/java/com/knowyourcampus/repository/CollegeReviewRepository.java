package com.knowyourcampus.repository;

import com.knowyourcampus.entity.CollegeReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeReviewRepository extends JpaRepository<CollegeReview, Long> {

    // Get all reviews for a specific college (only approved ones for public view)
    List<CollegeReview> findByCollegeIdAndApprovedTrue(Long collegeId);

    // Get all reviews for admin (including unapproved)
    List<CollegeReview> findByCollegeId(Long collegeId);

    // Get all pending reviews for admin moderation
    List<CollegeReview> findByApprovedFalse();

    // Get all reviews (for admin)
    List<CollegeReview> findAllByOrderByCreatedAtDesc();

    // Calculate average rating for a college
    @Query("SELECT AVG(r.rating) FROM CollegeReview r WHERE r.collegeId = :collegeId AND r.approved = true")
    Double getAverageRatingByCollegeId(Long collegeId);

    // Count total approved reviews for a college
    Long countByCollegeIdAndApprovedTrue(Long collegeId);
}

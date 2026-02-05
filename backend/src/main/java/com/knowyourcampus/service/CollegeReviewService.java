package com.knowyourcampus.service;

import com.knowyourcampus.entity.CollegeReview;
import com.knowyourcampus.repository.CollegeReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeReviewService {

    @Autowired
    private CollegeReviewRepository reviewRepository;

    // Get all approved reviews for a college (public view)
    public List<CollegeReview> getApprovedReviewsByCollegeId(Long collegeId) {
        return reviewRepository.findByCollegeIdAndApprovedTrue(collegeId);
    }

    // Get all reviews for a college (admin view)
    public List<CollegeReview> getAllReviewsByCollegeId(Long collegeId) {
        return reviewRepository.findByCollegeId(collegeId);
    }

    // Get all pending reviews for admin moderation
    public List<CollegeReview> getPendingReviews() {
        return reviewRepository.findByApprovedFalse();
    }

    // Get all reviews (admin)
    public List<CollegeReview> getAllReviews() {
        return reviewRepository.findAllByOrderByCreatedAtDesc();
    }

    // Create a new review (auto-unapproved, requires admin approval)
    public CollegeReview createReview(CollegeReview review) {
        review.setApproved(false); // Default to unapproved
        review.setVerified(false); // Default to unverified
        return reviewRepository.save(review);
    }

    // Approve a review (admin action)
    public CollegeReview approveReview(Long reviewId) {
        CollegeReview review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        review.setApproved(true);
        return reviewRepository.save(review);
    }

    // Reject/Delete a review (admin action)
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    // Update review (admin can edit)
    public CollegeReview updateReview(Long reviewId, CollegeReview updatedReview) {
        CollegeReview review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        review.setStudentName(updatedReview.getStudentName());
        review.setRating(updatedReview.getRating());
        review.setReviewTitle(updatedReview.getReviewTitle());
        review.setReviewText(updatedReview.getReviewText());
        review.setVerified(updatedReview.getVerified());

        return reviewRepository.save(review);
    }

    // Get average rating for a college
    public Double getAverageRating(Long collegeId) {
        Double avg = reviewRepository.getAverageRatingByCollegeId(collegeId);
        return avg != null ? Math.round(avg * 10.0) / 10.0 : 0.0; // Round to 1 decimal
    }

    // Get total review count for a college
    public Long getReviewCount(Long collegeId) {
        return reviewRepository.countByCollegeIdAndApprovedTrue(collegeId);
    }
}

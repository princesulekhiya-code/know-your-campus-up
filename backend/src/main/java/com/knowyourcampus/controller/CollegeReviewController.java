package com.knowyourcampus.controller;

import com.knowyourcampus.entity.CollegeReview;
import com.knowyourcampus.service.CollegeReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "*")
public class CollegeReviewController {

    @Autowired
    private CollegeReviewService reviewService;

    // Get all approved reviews for a college (public endpoint)
    @GetMapping("/college/{collegeId}")
    public ResponseEntity<List<CollegeReview>> getReviewsByCollegeId(@PathVariable Long collegeId) {
        return ResponseEntity.ok(reviewService.getApprovedReviewsByCollegeId(collegeId));
    }

    // Get average rating and review count for a college (public endpoint)
    @GetMapping("/college/{collegeId}/stats")
    public ResponseEntity<Map<String, Object>> getCollegeReviewStats(@PathVariable Long collegeId) {
        Map<String, Object> stats = new HashMap<>();
        stats.put("averageRating", reviewService.getAverageRating(collegeId));
        stats.put("totalReviews", reviewService.getReviewCount(collegeId));
        return ResponseEntity.ok(stats);
    }

    // Submit a new review (public endpoint - will be unapproved initially)
    @PostMapping
    public ResponseEntity<CollegeReview> createReview(@RequestBody CollegeReview review) {
        CollegeReview createdReview = reviewService.createReview(review);
        return ResponseEntity.ok(createdReview);
    }

    // Get all reviews for admin (including unapproved)
    @GetMapping("/admin/all")
    public ResponseEntity<List<CollegeReview>> getAllReviewsForAdmin() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    // Get pending reviews (admin endpoint)
    @GetMapping("/admin/pending")
    public ResponseEntity<List<CollegeReview>> getPendingReviews() {
        return ResponseEntity.ok(reviewService.getPendingReviews());
    }

    // Approve a review (admin endpoint)
    @PutMapping("/admin/{reviewId}/approve")
    public ResponseEntity<CollegeReview> approveReview(@PathVariable Long reviewId) {
        return ResponseEntity.ok(reviewService.approveReview(reviewId));
    }

    // Update a review (admin endpoint)
    @PutMapping("/admin/{reviewId}")
    public ResponseEntity<CollegeReview> updateReview(@PathVariable Long reviewId, @RequestBody CollegeReview review) {
        return ResponseEntity.ok(reviewService.updateReview(reviewId, review));
    }

    // Delete a review (admin endpoint)
    @DeleteMapping("/admin/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.ok().build();
    }
}

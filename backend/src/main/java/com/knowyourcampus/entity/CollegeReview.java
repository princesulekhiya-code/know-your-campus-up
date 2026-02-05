package com.knowyourcampus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "college_reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollegeReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id", nullable = false)
    @JsonIgnore
    private College college;

    @Column(name = "college_id", insertable = false, updatable = false)
    private Long collegeId;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false)
    private String studentEmail;

    @Column(nullable = false)
    private Integer rating; // 1 to 5

    private String reviewTitle;

    @Column(length = 2000)
    private String reviewText;

    private String course; // Which course they studied

    private String batchYear; // e.g., 2020-2024

    @Column(nullable = false)
    private Boolean verified = false; // For verified students

    @Column(nullable = false)
    private Boolean approved = false; // Admin moderation

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Helper method to ensure rating is between 1 and 5
    public void setRating(Integer rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.rating = rating;
    }
}

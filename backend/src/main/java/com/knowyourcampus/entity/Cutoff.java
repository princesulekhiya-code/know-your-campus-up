package com.knowyourcampus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cutoffs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cutoff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    @JsonIgnore
    private Course course;

    @Column(nullable = false)
    private String category; // GENERAL, OBC, SC, ST, EWS

    @Column(nullable = false)
    private String academicYear; // 2023-2024

    @Column(nullable = false)
    private String round; // Round 1, Round 2, etc.

    @Column(precision = 5, scale = 2)
    private BigDecimal cutoffPercentage;

    private Integer cutoffRank;

    private String examType; // JEE, NEET, CAT, State Entrance, etc.

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}

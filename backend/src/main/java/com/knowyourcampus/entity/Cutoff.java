package com.knowyourcampus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cutoffs")
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

    // Explicit Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getAcademicYear() { return academicYear; }
    public void setAcademicYear(String academicYear) { this.academicYear = academicYear; }
    public String getRound() { return round; }
    public void setRound(String round) { this.round = round; }
    public BigDecimal getCutoffPercentage() { return cutoffPercentage; }
    public void setCutoffPercentage(BigDecimal cutoffPercentage) { this.cutoffPercentage = cutoffPercentage; }
    public Integer getCutoffRank() { return cutoffRank; }
    public void setCutoffRank(Integer cutoffRank) { this.cutoffRank = cutoffRank; }
    public String getExamType() { return examType; }
    public void setExamType(String examType) { this.examType = examType; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}

package com.knowyourcampus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fee_structure")
public class FeeStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    @JsonIgnore
    private Course course;

    @Column(nullable = false)
    private String academicYear; // 2026-27

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tuitionFee;

    @Column(precision = 10, scale = 2)
    private BigDecimal hostelFee;

    @Column(precision = 10, scale = 2)
    private BigDecimal transportFee;

    @Column(precision = 10, scale = 2)
    private BigDecimal libraryFee;

    @Column(precision = 10, scale = 2)
    private BigDecimal labFee;

    @Column(precision = 10, scale = 2)
    private BigDecimal otherFees;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalFee;

    private String feeType; // PER_YEAR, PER_SEMESTER, ONE_TIME

    @Column(length = 1000)
    private String remarks;

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
    public String getAcademicYear() { return academicYear; }
    public void setAcademicYear(String academicYear) { this.academicYear = academicYear; }
    public BigDecimal getTuitionFee() { return tuitionFee; }
    public void setTuitionFee(BigDecimal tuitionFee) { this.tuitionFee = tuitionFee; }
    public BigDecimal getHostelFee() { return hostelFee; }
    public void setHostelFee(BigDecimal hostelFee) { this.hostelFee = hostelFee; }
    public BigDecimal getTransportFee() { return transportFee; }
    public void setTransportFee(BigDecimal transportFee) { this.transportFee = transportFee; }
    public BigDecimal getLibraryFee() { return libraryFee; }
    public void setLibraryFee(BigDecimal libraryFee) { this.libraryFee = libraryFee; }
    public BigDecimal getLabFee() { return labFee; }
    public void setLabFee(BigDecimal labFee) { this.labFee = labFee; }
    public BigDecimal getOtherFees() { return otherFees; }
    public void setOtherFees(BigDecimal otherFees) { this.otherFees = otherFees; }
    public BigDecimal getTotalFee() { return totalFee; }
    public void setTotalFee(BigDecimal totalFee) { this.totalFee = totalFee; }
    public String getFeeType() { return feeType; }
    public void setFeeType(String feeType) { this.feeType = feeType; }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}

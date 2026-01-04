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
@Table(name = "fee_structure")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    @JsonIgnore
    private Course course;

    @Column(nullable = false)
    private String academicYear; // 2024-2025

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
}

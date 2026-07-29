package com.knowyourcampus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id", nullable = false)
    @JsonIgnore
    private College college;

    @Column(nullable = false)
    private String name; // B.Tech, M.Tech, MBA, BBA, etc.

    @Column(nullable = false)
    private String specialization; // Computer Science, Mechanical, etc.

    @Column(nullable = false)
    private String degree; // UG, PG, Diploma

    private Integer durationYears;

    @Column(length = 2000)
    private String description;

    private String eligibility;

    private Boolean active = true;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeatMatrix> seatMatrices = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FeeStructure> feeStructures = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cutoff> cutoffs = new ArrayList<>();

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // Explicit Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public College getCollege() { return college; }
    public void setCollege(College college) { this.college = college; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }
    public Integer getDurationYears() { return durationYears; }
    public void setDurationYears(Integer durationYears) { this.durationYears = durationYears; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getEligibility() { return eligibility; }
    public void setEligibility(String eligibility) { this.eligibility = eligibility; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public List<SeatMatrix> getSeatMatrices() { return seatMatrices; }
    public void setSeatMatrices(List<SeatMatrix> seatMatrices) { this.seatMatrices = seatMatrices; }
    public List<FeeStructure> getFeeStructures() { return feeStructures; }
    public void setFeeStructures(List<FeeStructure> feeStructures) { this.feeStructures = feeStructures; }
    public List<Cutoff> getCutoffs() { return cutoffs; }
    public void setCutoffs(List<Cutoff> cutoffs) { this.cutoffs = cutoffs; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}

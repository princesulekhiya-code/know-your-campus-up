package com.knowyourcampus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "colleges")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private String type; // GOVERNMENT or PRIVATE

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    private String address;

    private String pincode;

    private String phone;

    private String email;

    private String website;

    private String naacRating; // A++, A+, A, B++, B+, B, C, Not Accredited

    private Boolean admissionOpen = true;

    @Column(length = 2000)
    private String logoUrl;

    @Column(length = 2000)
    private String bannerUrl;

    @Column(length = 3000)
    private String facilities; // Comma-separated or JSON

    private Integer establishedYear;

    private String affiliatedTo;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses = new ArrayList<>();

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}

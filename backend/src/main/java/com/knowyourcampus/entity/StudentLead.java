package com.knowyourcampus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_leads")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentLead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private String email;

    private String city;

    private String state;

    @Column(nullable = false)
    private String interestedCourse;

    private String interestedSpecialization;

    private Long collegeId;

    private String collegeName;

    private String leadSource; // ADMISSION_FORM, ENQUIRY, CONTACT_FORM, etc.

    private String status = "NEW"; // NEW, CONTACTED, QUALIFIED, CONVERTED, LOST

    @Column(length = 2000)
    private String message;

    private String ipAddress;

    private String sessionId;

    @Column(length = 1000)
    private String remarks;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}

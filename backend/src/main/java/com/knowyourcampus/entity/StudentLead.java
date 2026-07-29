package com.knowyourcampus.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_leads")
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

    // Explicit Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getInterestedCourse() { return interestedCourse; }
    public void setInterestedCourse(String interestedCourse) { this.interestedCourse = interestedCourse; }
    public String getInterestedSpecialization() { return interestedSpecialization; }
    public void setInterestedSpecialization(String interestedSpecialization) { this.interestedSpecialization = interestedSpecialization; }
    public Long getCollegeId() { return collegeId; }
    public void setCollegeId(Long collegeId) { this.collegeId = collegeId; }
    public String getCollegeName() { return collegeName; }
    public void setCollegeName(String collegeName) { this.collegeName = collegeName; }
    public String getLeadSource() { return leadSource; }
    public void setLeadSource(String leadSource) { this.leadSource = leadSource; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

package com.knowyourcampus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "page_tracking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pagePath;

    private String pageTitle;

    private Long collegeId;

    private Long courseId;

    private String ipAddress;

    private String sessionId;

    private String userAgent;

    private String referrer;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime visitedAt;
}

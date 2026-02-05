package com.knowyourcampus.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    private String link;

    private boolean isUrgent;

    private boolean isActive = true;

    private String eventDate;

    private LocalDateTime createdAt = LocalDateTime.now();
}

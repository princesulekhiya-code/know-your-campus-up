package com.knowyourcampus.controller;

import com.knowyourcampus.dto.AnalyticsDashboardDTO;
import com.knowyourcampus.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analytics")
@CrossOrigin(origins = "*")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/dashboard")
    public ResponseEntity<AnalyticsDashboardDTO> getDashboardData() {
        return ResponseEntity.ok(analyticsService.getDashboardData());
    }
}

package com.knowyourcampus.controller;

import com.knowyourcampus.entity.PageTracking;
import com.knowyourcampus.service.PageTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracking")
@CrossOrigin(origins = "*")
public class PageTrackingController {

    @Autowired
    private PageTrackingService pageTrackingService;

    @PostMapping
    public ResponseEntity<PageTracking> trackPageVisit(@RequestBody PageTracking tracking) {
        return ResponseEntity.ok(pageTrackingService.trackPageVisit(tracking));
    }

    @GetMapping("/college/{collegeId}/views")
    public ResponseEntity<Long> getCollegeViewCount(@PathVariable Long collegeId) {
        return ResponseEntity.ok(pageTrackingService.getViewCountByCollege(collegeId));
    }
}

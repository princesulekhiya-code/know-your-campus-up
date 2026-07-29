package com.knowyourcampus.controller;

import com.knowyourcampus.config.MPMedicalCollegeSeeder;
import com.knowyourcampus.config.MPCollegeSeeder;
import com.knowyourcampus.config.BhopalCollegeSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/seed")
@CrossOrigin(origins = "*")
public class DataSeederController {

    @Autowired
    private MPMedicalCollegeSeeder mpMedicalCollegeSeeder;

    @Autowired
    private MPCollegeSeeder mpCollegeSeeder;

    @Autowired
    private BhopalCollegeSeeder bhopalCollegeSeeder;

    @GetMapping("/medical")
    public ResponseEntity<Map<String, String>> seedMedicalColleges() {
        Map<String, String> response = new HashMap<>();
        try {
            mpMedicalCollegeSeeder.seedAllMPMedicalColleges();
            response.put("status", "SUCCESS");
            response.put("message", "All MP Medical Colleges (MBBS, BAMS, BHMS, BDS, BPT) seeded successfully!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "ERROR");
            response.put("message", "Failed to seed medical colleges: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, String>> seedAllColleges() {
        Map<String, String> response = new HashMap<>();
        try {
            bhopalCollegeSeeder.seedBhopalColleges();
            mpCollegeSeeder.seedAllMPColleges();
            mpMedicalCollegeSeeder.seedAllMPMedicalColleges();
            response.put("status", "SUCCESS");
            response.put("message", "All MP Colleges & Medical Colleges seeded successfully!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "ERROR");
            response.put("message", "Failed to seed colleges: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }
}

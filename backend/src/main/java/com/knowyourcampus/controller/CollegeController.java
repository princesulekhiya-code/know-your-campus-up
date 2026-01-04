package com.knowyourcampus.controller;

import com.knowyourcampus.entity.College;
import com.knowyourcampus.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
@CrossOrigin(origins = "*")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping
    public ResponseEntity<List<College>> getAllColleges(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String naacRating,
            @RequestParam(required = false) Boolean admissionOpen) {

        if (type != null || city != null || state != null || naacRating != null || admissionOpen != null) {
            return ResponseEntity.ok(collegeService.filterColleges(type, city, state, naacRating, admissionOpen));
        }
        return ResponseEntity.ok(collegeService.getAllColleges());
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        return ResponseEntity.ok(collegeService.getCollegeById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<College>> searchColleges(@RequestParam String q) {
        return ResponseEntity.ok(collegeService.searchColleges(q));
    }

    @PostMapping
    public ResponseEntity<College> createCollege(@RequestBody College college) {
        return ResponseEntity.ok(collegeService.createCollege(college));
    }

    @PutMapping("/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable Long id, @RequestBody College college) {
        return ResponseEntity.ok(collegeService.updateCollege(id, college));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Long id) {
        collegeService.deleteCollege(id);
        return ResponseEntity.ok().build();
    }
}

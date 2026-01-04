package com.knowyourcampus.controller;

import com.knowyourcampus.entity.Cutoff;
import com.knowyourcampus.service.CutoffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cutoffs")
@CrossOrigin(origins = "*")
public class CutoffController {

    @Autowired
    private CutoffService cutoffService;

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Cutoff>> getCutoffsByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(cutoffService.getCutoffsByCourseId(courseId));
    }

    @PostMapping
    public ResponseEntity<Cutoff> createCutoff(@RequestBody Cutoff cutoff) {
        return ResponseEntity.ok(cutoffService.createCutoff(cutoff));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cutoff> updateCutoff(@PathVariable Long id, @RequestBody Cutoff cutoff) {
        return ResponseEntity.ok(cutoffService.updateCutoff(id, cutoff));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCutoff(@PathVariable Long id) {
        cutoffService.deleteCutoff(id);
        return ResponseEntity.ok().build();
    }
}

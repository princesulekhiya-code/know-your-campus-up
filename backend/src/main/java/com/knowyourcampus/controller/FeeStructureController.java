package com.knowyourcampus.controller;

import com.knowyourcampus.entity.FeeStructure;
import com.knowyourcampus.service.FeeStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fees")
@CrossOrigin(origins = "*")
public class FeeStructureController {

    @Autowired
    private FeeStructureService feeStructureService;

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<FeeStructure>> getFeesByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(feeStructureService.getFeesByCourseId(courseId));
    }

    @PostMapping
    public ResponseEntity<FeeStructure> createFee(@RequestBody FeeStructure feeStructure) {
        return ResponseEntity.ok(feeStructureService.createFee(feeStructure));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeeStructure> updateFee(@PathVariable Long id, @RequestBody FeeStructure feeStructure) {
        return ResponseEntity.ok(feeStructureService.updateFee(id, feeStructure));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFee(@PathVariable Long id) {
        feeStructureService.deleteFee(id);
        return ResponseEntity.ok().build();
    }
}

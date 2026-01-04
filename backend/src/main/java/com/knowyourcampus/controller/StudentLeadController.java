package com.knowyourcampus.controller;

import com.knowyourcampus.entity.StudentLead;
import com.knowyourcampus.service.StudentLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
@CrossOrigin(origins = "*")
public class StudentLeadController {

    @Autowired
    private StudentLeadService studentLeadService;

    @PostMapping("/submit")
    public ResponseEntity<StudentLead> submitLead(@RequestBody StudentLead lead) {
        return ResponseEntity.ok(studentLeadService.createLead(lead));
    }

    @GetMapping
    public ResponseEntity<List<StudentLead>> getAllLeads() {
        return ResponseEntity.ok(studentLeadService.getAllLeads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentLead> getLeadById(@PathVariable Long id) {
        return ResponseEntity.ok(studentLeadService.getLeadById(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<StudentLead>> getLeadsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(studentLeadService.getLeadsByStatus(status));
    }

    @GetMapping("/college/{collegeId}")
    public ResponseEntity<List<StudentLead>> getLeadsByCollegeId(@PathVariable Long collegeId) {
        return ResponseEntity.ok(studentLeadService.getLeadsByCollegeId(collegeId));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<StudentLead> updateLeadStatus(
            @PathVariable Long id,
            @RequestParam String status,
            @RequestParam(required = false) String remarks) {
        return ResponseEntity.ok(studentLeadService.updateLeadStatus(id, status, remarks));
    }
}

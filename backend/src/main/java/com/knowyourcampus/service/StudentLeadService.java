package com.knowyourcampus.service;

import com.knowyourcampus.entity.StudentLead;
import com.knowyourcampus.repository.StudentLeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class StudentLeadService {

    @Autowired
    private StudentLeadRepository studentLeadRepository;

    public List<StudentLead> getAllLeads() {
        return studentLeadRepository.findAllOrderByCreatedAtDesc();
    }

    public StudentLead getLeadById(Long id) {
        return studentLeadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead not found with id: " + id));
    }

    public List<StudentLead> getLeadsByStatus(String status) {
        return studentLeadRepository.findByStatus(status);
    }

    public List<StudentLead> getLeadsByCollegeId(Long collegeId) {
        return studentLeadRepository.findByCollegeId(collegeId);
    }

    public List<StudentLead> getRecentLeads(int days) {
        LocalDateTime startDate = LocalDateTime.now().minusDays(days);
        return studentLeadRepository.findRecentLeads(startDate);
    }

    public StudentLead createLead(StudentLead lead) {
        return studentLeadRepository.save(lead);
    }

    public StudentLead updateLeadStatus(Long id, String status, String remarks) {
        StudentLead lead = getLeadById(id);
        lead.setStatus(status);
        if (remarks != null) {
            lead.setRemarks(remarks);
        }
        return studentLeadRepository.save(lead);
    }

    public Long countLeadsByCollege(Long collegeId) {
        return studentLeadRepository.countByCollegeId(collegeId);
    }
}

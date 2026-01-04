package com.knowyourcampus.service;

import com.knowyourcampus.dto.AnalyticsDashboardDTO;
import com.knowyourcampus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnalyticsService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentLeadRepository studentLeadRepository;

    @Autowired
    private PageTrackingRepository pageTrackingRepository;

    public AnalyticsDashboardDTO getDashboardData() {
        AnalyticsDashboardDTO dashboard = new AnalyticsDashboardDTO();

        // Basic counts
        dashboard.setTotalColleges(collegeRepository.count());
        dashboard.setTotalCourses(courseRepository.count());
        dashboard.setTotalLeads(studentLeadRepository.count());

        // Today's data
        LocalDateTime startOfDay = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        dashboard.setNewLeadsToday(studentLeadRepository.findRecentLeads(startOfDay).size() * 1L);
        dashboard.setPageViewsToday(pageTrackingRepository.countVisitsSince(startOfDay));

        // Total page views
        dashboard.setTotalPageViews(pageTrackingRepository.count());

        // Leads by status
        Map<String, Long> leadsByStatus = new HashMap<>();
        List<Object[]> statusCounts = studentLeadRepository.countByStatus();
        for (Object[] row : statusCounts) {
            leadsByStatus.put((String) row[0], (Long) row[1]);
        }
        dashboard.setLeadsByStatus(leadsByStatus);

        // Most viewed colleges
        Map<String, Long> mostViewedColleges = new HashMap<>();
        List<Object[]> viewCounts = pageTrackingRepository.findMostViewedColleges();
        int count = 0;
        for (Object[] row : viewCounts) {
            if (count >= 10)
                break; // Top 10
            Long collegeId = (Long) row[0];
            Long views = (Long) row[1];
            collegeRepository.findById(collegeId)
                    .ifPresent(college -> mostViewedColleges.put(college.getName(), views));
            count++;
        }
        dashboard.setMostViewedColleges(mostViewedColleges);

        return dashboard;
    }
}

package com.knowyourcampus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsDashboardDTO {
    private Long totalColleges;
    private Long totalCourses;
    private Long totalLeads;
    private Long newLeadsToday;
    private Long totalPageViews;
    private Long pageViewsToday;
    private Map<String, Long> leadsByStatus;
    private Map<String, Long> mostViewedColleges;
}

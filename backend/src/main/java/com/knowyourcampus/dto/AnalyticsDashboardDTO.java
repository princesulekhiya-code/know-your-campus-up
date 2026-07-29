package com.knowyourcampus.dto;

import java.util.Map;

public class AnalyticsDashboardDTO {
    private Long totalColleges;
    private Long totalCourses;
    private Long totalLeads;
    private Long newLeadsToday;
    private Long totalPageViews;
    private Long pageViewsToday;
    private Map<String, Long> leadsByStatus;
    private Map<String, Long> mostViewedColleges;

    public Long getTotalColleges() { return totalColleges; }
    public void setTotalColleges(Long totalColleges) { this.totalColleges = totalColleges; }
    public Long getTotalCourses() { return totalCourses; }
    public void setTotalCourses(Long totalCourses) { this.totalCourses = totalCourses; }
    public Long getTotalLeads() { return totalLeads; }
    public void setTotalLeads(Long totalLeads) { this.totalLeads = totalLeads; }
    public Long getNewLeadsToday() { return newLeadsToday; }
    public void setNewLeadsToday(Long newLeadsToday) { this.newLeadsToday = newLeadsToday; }
    public Long getTotalPageViews() { return totalPageViews; }
    public void setTotalPageViews(Long totalPageViews) { this.totalPageViews = totalPageViews; }
    public Long getPageViewsToday() { return pageViewsToday; }
    public void setPageViewsToday(Long pageViewsToday) { this.pageViewsToday = pageViewsToday; }
    public Map<String, Long> getLeadsByStatus() { return leadsByStatus; }
    public void setLeadsByStatus(Map<String, Long> leadsByStatus) { this.leadsByStatus = leadsByStatus; }
    public Map<String, Long> getMostViewedColleges() { return mostViewedColleges; }
    public void setMostViewedColleges(Map<String, Long> mostViewedColleges) { this.mostViewedColleges = mostViewedColleges; }
}

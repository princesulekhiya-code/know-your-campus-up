package com.knowyourcampus.service;

import com.knowyourcampus.entity.PageTracking;
import com.knowyourcampus.repository.PageTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class PageTrackingService {

    @Autowired
    private PageTrackingRepository pageTrackingRepository;

    public PageTracking trackPageVisit(PageTracking tracking) {
        return pageTrackingRepository.save(tracking);
    }

    public List<PageTracking> getRecentVisits(int days) {
        LocalDateTime startDate = LocalDateTime.now().minusDays(days);
        return pageTrackingRepository.findRecentVisits(startDate);
    }

    public Long getViewCountByCollege(Long collegeId) {
        return pageTrackingRepository.countByCollegeId(collegeId);
    }

    public List<Object[]> getMostViewedColleges() {
        return pageTrackingRepository.findMostViewedColleges();
    }

    public Long getTotalVisitsSince(int days) {
        LocalDateTime startDate = LocalDateTime.now().minusDays(days);
        return pageTrackingRepository.countVisitsSince(startDate);
    }
}

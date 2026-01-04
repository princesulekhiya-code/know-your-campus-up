package com.knowyourcampus.service;

import com.knowyourcampus.entity.College;
import com.knowyourcampus.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    public College getCollegeById(Long id) {
        return collegeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("College not found with id: " + id));
    }

    public List<College> searchColleges(String query) {
        return collegeRepository.searchColleges(query);
    }

    public List<College> filterColleges(String type, String city, String state, String naacRating,
            Boolean admissionOpen) {
        return collegeRepository.filterColleges(type, city, state, naacRating, admissionOpen);
    }

    public College createCollege(College college) {
        return collegeRepository.save(college);
    }

    public College updateCollege(Long id, College collegeDetails) {
        College college = getCollegeById(id);

        college.setName(collegeDetails.getName());
        college.setDescription(collegeDetails.getDescription());
        college.setType(collegeDetails.getType());
        college.setCity(collegeDetails.getCity());
        college.setState(collegeDetails.getState());
        college.setAddress(collegeDetails.getAddress());
        college.setPincode(collegeDetails.getPincode());
        college.setPhone(collegeDetails.getPhone());
        college.setEmail(collegeDetails.getEmail());
        college.setWebsite(collegeDetails.getWebsite());
        college.setNaacRating(collegeDetails.getNaacRating());
        college.setAdmissionOpen(collegeDetails.getAdmissionOpen());
        college.setLogoUrl(collegeDetails.getLogoUrl());
        college.setBannerUrl(collegeDetails.getBannerUrl());
        college.setFacilities(collegeDetails.getFacilities());
        college.setEstablishedYear(collegeDetails.getEstablishedYear());
        college.setAffiliatedTo(collegeDetails.getAffiliatedTo());

        return collegeRepository.save(college);
    }

    public void deleteCollege(Long id) {
        College college = getCollegeById(id);
        collegeRepository.delete(college);
    }
}

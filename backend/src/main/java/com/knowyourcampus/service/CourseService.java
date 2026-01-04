package com.knowyourcampus.service;

import com.knowyourcampus.entity.Course;
import com.knowyourcampus.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    public List<Course> getCoursesByCollegeId(Long collegeId) {
        return courseRepository.findByCollegeId(collegeId);
    }

    public List<Course> getActiveCoursesByCollegeId(Long collegeId) {
        return courseRepository.findActiveByCollegeId(collegeId);
    }

    public List<Course> searchCourses(String query) {
        return courseRepository.searchCourses(query);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course course = getCourseById(id);

        course.setName(courseDetails.getName());
        course.setSpecialization(courseDetails.getSpecialization());
        course.setDegree(courseDetails.getDegree());
        course.setDurationYears(courseDetails.getDurationYears());
        course.setDescription(courseDetails.getDescription());
        course.setEligibility(courseDetails.getEligibility());
        course.setActive(courseDetails.getActive());

        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }
}

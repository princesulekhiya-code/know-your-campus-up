package com.knowyourcampus.repository;

import com.knowyourcampus.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

        College findByName(String name);

        List<College> findByType(String type);

        List<College> findByCity(String city);

        List<College> findByState(String state);

        List<College> findByNaacRating(String naacRating);

        List<College> findByAdmissionOpen(Boolean admissionOpen);

        @Query("SELECT c FROM College c WHERE " +
                        "LOWER(c.name) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
                        "LOWER(c.city) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
                        "LOWER(c.state) LIKE LOWER(CONCAT('%', :query, '%'))")
        List<College> searchColleges(@Param("query") String query);

        @Query("SELECT c FROM College c WHERE " +
                        "(:type IS NULL OR c.type = :type) AND " +
                        "(:city IS NULL OR c.city = :city) AND " +
                        "(:state IS NULL OR c.state = :state) AND " +
                        "(:naacRating IS NULL OR c.naacRating = :naacRating) AND " +
                        "(:admissionOpen IS NULL OR c.admissionOpen = :admissionOpen)")
        List<College> filterColleges(
                        @Param("type") String type,
                        @Param("city") String city,
                        @Param("state") String state,
                        @Param("naacRating") String naacRating,
                        @Param("admissionOpen") Boolean admissionOpen);
}

package com.knowyourcampus.service;

import com.knowyourcampus.entity.Cutoff;
import com.knowyourcampus.repository.CutoffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CutoffService {

    @Autowired
    private CutoffRepository cutoffRepository;

    public List<Cutoff> getAllCutoffs() {
        return cutoffRepository.findAll();
    }

    public Cutoff getCutoffById(Long id) {
        return cutoffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cutoff not found with id: " + id));
    }

    public List<Cutoff> getCutoffsByCourseId(Long courseId) {
        return cutoffRepository.findByCourseIdOrderByAcademicYearDesc(courseId);
    }

    public Cutoff createCutoff(Cutoff cutoff) {
        return cutoffRepository.save(cutoff);
    }

    public Cutoff updateCutoff(Long id, Cutoff cutoffDetails) {
        Cutoff cutoff = getCutoffById(id);

        cutoff.setCategory(cutoffDetails.getCategory());
        cutoff.setAcademicYear(cutoffDetails.getAcademicYear());
        cutoff.setRound(cutoffDetails.getRound());
        cutoff.setCutoffPercentage(cutoffDetails.getCutoffPercentage());
        cutoff.setCutoffRank(cutoffDetails.getCutoffRank());
        cutoff.setExamType(cutoffDetails.getExamType());

        return cutoffRepository.save(cutoff);
    }

    public void deleteCutoff(Long id) {
        Cutoff cutoff = getCutoffById(id);
        cutoffRepository.delete(cutoff);
    }
}

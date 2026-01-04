package com.knowyourcampus.service;

import com.knowyourcampus.entity.FeeStructure;
import com.knowyourcampus.repository.FeeStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeeStructureService {
    
    @Autowired
    private FeeStructureRepository feeStructureRepository;
    
    public List<FeeStructure> getAllFees() {
        return feeStructureRepository.findAll();
    }
    
    public FeeStructure getFeeById(Long id) {
        return feeStructureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fee structure not found with id: " + id));
    }
    
    public List<FeeStructure> getFeesByCourseId(Long courseId) {
        return feeStructureRepository.findByCourseId(courseId);
    }
    
    public FeeStructure createFee(FeeStructure feeStructure) {
        return feeStructureRepository.save(feeStructure);
    }
    
    public FeeStructure updateFee(Long id, FeeStructure feeDetails) {
        FeeStructure fee = getFeeById(id);
        
        fee.setAcademicYear(feeDetails.getAcademicYear());
        fee.setTuitionFee(feeDetails.getTuitionFee());
        fee.setHostelFee(feeDetails.getHostelFee());
        fee.setTransportFee(feeDetails.getTransportFee());
        fee.setLibraryFee(feeDetails.getLibraryFee());
        fee.setLabFee(feeDetails.getLabFee());
        fee.setOtherFees(feeDetails.getOtherFees());
        fee.setTotalFee(feeDetails.getTotalFee());
        fee.setFeeType(feeDetails.getFeeType());
        fee.setRemarks(feeDetails.getRemarks());
        
        return feeStructureRepository.save(fee);
    }
    
    public void deleteFee(Long id) {
        FeeStructure fee = getFeeById(id);
        feeStructureRepository.delete(fee);
    }
}

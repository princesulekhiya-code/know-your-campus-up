package com.knowyourcampus.service;

import com.knowyourcampus.entity.SeatMatrix;
import com.knowyourcampus.repository.SeatMatrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SeatMatrixService {

    @Autowired
    private SeatMatrixRepository seatMatrixRepository;

    public List<SeatMatrix> getAllSeats() {
        return seatMatrixRepository.findAll();
    }

    public SeatMatrix getSeatById(Long id) {
        return seatMatrixRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat matrix not found with id: " + id));
    }

    public List<SeatMatrix> getSeatsByCourseId(Long courseId) {
        return seatMatrixRepository.findByCourseId(courseId);
    }

    public List<SeatMatrix> getSeatsByCourseIdAndYear(Long courseId, String academicYear) {
        return seatMatrixRepository.findByCourseIdAndAcademicYear(courseId, academicYear);
    }

    public SeatMatrix createSeat(SeatMatrix seatMatrix) {
        return seatMatrixRepository.save(seatMatrix);
    }

    public SeatMatrix updateSeat(Long id, SeatMatrix seatDetails) {
        SeatMatrix seat = getSeatById(id);

        seat.setCategory(seatDetails.getCategory());
        seat.setTotalSeats(seatDetails.getTotalSeats());
        seat.setAvailableSeats(seatDetails.getAvailableSeats());
        seat.setAcademicYear(seatDetails.getAcademicYear());

        return seatMatrixRepository.save(seat);
    }

    public void deleteSeat(Long id) {
        SeatMatrix seat = getSeatById(id);
        seatMatrixRepository.delete(seat);
    }
}

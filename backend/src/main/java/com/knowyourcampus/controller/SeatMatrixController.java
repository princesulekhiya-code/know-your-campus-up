package com.knowyourcampus.controller;

import com.knowyourcampus.entity.SeatMatrix;
import com.knowyourcampus.service.SeatMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
@CrossOrigin(origins = "*")
public class SeatMatrixController {

    @Autowired
    private SeatMatrixService seatMatrixService;

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<SeatMatrix>> getSeatsByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(seatMatrixService.getSeatsByCourseId(courseId));
    }

    @PostMapping
    public ResponseEntity<SeatMatrix> createSeat(@RequestBody SeatMatrix seatMatrix) {
        return ResponseEntity.ok(seatMatrixService.createSeat(seatMatrix));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeatMatrix> updateSeat(@PathVariable Long id, @RequestBody SeatMatrix seatMatrix) {
        return ResponseEntity.ok(seatMatrixService.updateSeat(id, seatMatrix));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long id) {
        seatMatrixService.deleteSeat(id);
        return ResponseEntity.ok().build();
    }
}

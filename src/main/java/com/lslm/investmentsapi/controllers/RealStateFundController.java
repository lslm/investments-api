package com.lslm.investmentsapi.controllers;

import com.lslm.investmentsapi.exceptions.NotFoundException;
import com.lslm.investmentsapi.models.RealStateFund;
import com.lslm.investmentsapi.services.RealStateFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController()
@RequestMapping("/api/investments/real-state-funds")
public class RealStateFundController {
    @Autowired
    private RealStateFundService realStateFundService;

    @GetMapping
    public ResponseEntity<List<RealStateFund>> findAll() {
        List<RealStateFund> realStateFundInvestments = realStateFundService.findAll();
        return new ResponseEntity<>(realStateFundInvestments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RealStateFund> createRealStateFundInvestment(@RequestBody RealStateFund realStateFund) {
        RealStateFund createdRealStateFundInvestment = realStateFundService.create(realStateFund);
        return new ResponseEntity<>(createdRealStateFundInvestment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RealStateFund> findById(@PathVariable Long id) {
        try {
            RealStateFund realStateFundInvestment = realStateFundService.find(id);
            return new ResponseEntity<>(realStateFundInvestment, HttpStatus.OK);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RealStateFund> update(@PathVariable Long id, @RequestBody RealStateFund realStateFund) {
        try {
            RealStateFund updatedRealStateFundInvestment = realStateFundService.update(id, realStateFund);
            return new ResponseEntity<>(updatedRealStateFundInvestment, HttpStatus.CREATED);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            realStateFundService.delete(id);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

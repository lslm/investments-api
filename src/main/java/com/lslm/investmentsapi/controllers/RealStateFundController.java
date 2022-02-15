package com.lslm.investmentsapi.controllers;

import com.lslm.investmentsapi.exceptions.NotFoundException;
import com.lslm.investmentsapi.models.RealStateFundInvestment;
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
    public ResponseEntity<List<RealStateFundInvestment>> findAll() {
        List<RealStateFundInvestment> realStateFundInvestmentInvestments = realStateFundService.findAll();
        return new ResponseEntity<>(realStateFundInvestmentInvestments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RealStateFundInvestment> createRealStateFundInvestment(@RequestBody RealStateFundInvestment realStateFundInvestment) {
        RealStateFundInvestment createdRealStateFundInvestmentInvestment = realStateFundService.create(realStateFundInvestment);
        return new ResponseEntity<>(createdRealStateFundInvestmentInvestment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RealStateFundInvestment> findById(@PathVariable Long id) {
        try {
            RealStateFundInvestment realStateFundInvestment = realStateFundService.find(id);
            return new ResponseEntity<>(realStateFundInvestment, HttpStatus.OK);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RealStateFundInvestment> update(@PathVariable Long id, @RequestBody RealStateFundInvestment realStateFundInvestment) {
        try {
            RealStateFundInvestment updatedRealStateFundInvestmentInvestment = realStateFundService.update(id, realStateFundInvestment);
            return new ResponseEntity<>(updatedRealStateFundInvestmentInvestment, HttpStatus.CREATED);
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

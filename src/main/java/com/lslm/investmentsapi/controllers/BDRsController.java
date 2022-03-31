package com.lslm.investmentsapi.controllers;

import com.lslm.investmentsapi.models.BDRInvestment;
import com.lslm.investmentsapi.services.BDRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/investments/bdrs")
public class BDRsController {
    @Autowired
    private BDRService bdrService;

    @PostMapping
    public ResponseEntity<BDRInvestment> createBDRInvestment(@RequestBody BDRInvestment bdrInvestment) {
        BDRInvestment createdBDRInvestment = bdrService.create(bdrInvestment);
        return new ResponseEntity<>(createdBDRInvestment, HttpStatus.CREATED);
    }
}

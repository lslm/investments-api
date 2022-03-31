package com.lslm.investmentsapi.services;

import com.lslm.investmentsapi.models.BDRInvestment;
import com.lslm.investmentsapi.repositories.BDRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BDRService {
    @Autowired
    private BDRRepository BDRRepository;

    public BDRInvestment create(BDRInvestment newBDRInvestment) {
        return BDRRepository.save(newBDRInvestment);
    }
}

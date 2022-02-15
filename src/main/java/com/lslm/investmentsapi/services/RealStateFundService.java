package com.lslm.investmentsapi.services;

import com.lslm.investmentsapi.exceptions.NotFoundException;
import com.lslm.investmentsapi.models.RealStateFundInvestment;
import com.lslm.investmentsapi.repositories.RealStateFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealStateFundService {
    @Autowired
    private RealStateFundRepository realStateFundRepository;

    public List<RealStateFundInvestment> findAll() {
        return realStateFundRepository.findAll();
    }

    public RealStateFundInvestment find(Long id) throws NotFoundException {
        Optional<RealStateFundInvestment> realStateFund = realStateFundRepository.findById(id);

        if(realStateFund.isPresent())
            return realStateFund.get();
        else
            throw new NotFoundException();
    }

    public RealStateFundInvestment create(RealStateFundInvestment newRealStateFundInvestment) {
        return realStateFundRepository.save(newRealStateFundInvestment);
    }

    public RealStateFundInvestment update(Long id, RealStateFundInvestment updatedRealStateFundInvestment) throws NotFoundException {
        RealStateFundInvestment realStateFundInvestment = find(id);
        return realStateFundRepository.save(realStateFundInvestment);
    }

    public void delete(Long id) throws NotFoundException {
        RealStateFundInvestment realStateFundInvestment = find(id);
        realStateFundRepository.delete(realStateFundInvestment);
    }
}

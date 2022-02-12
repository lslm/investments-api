package com.lslm.investmentsapi.services;

import com.lslm.investmentsapi.exceptions.NotFoundException;
import com.lslm.investmentsapi.models.RealStateFund;
import com.lslm.investmentsapi.repositories.RealStateFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealStateFundService {
    @Autowired
    private RealStateFundRepository realStateFundRepository;

    public List<RealStateFund> findAll() {
        return realStateFundRepository.findAll();
    }

    public RealStateFund find(Long id) throws NotFoundException {
        Optional<RealStateFund> realStateFund = realStateFundRepository.findById(id);

        if(realStateFund.isPresent())
            return realStateFund.get();
        else
            throw new NotFoundException();
    }

    public RealStateFund create(RealStateFund newRealStateFund) {
        return realStateFundRepository.save(newRealStateFund);
    }

    public RealStateFund update(Long id, RealStateFund updatedRealStateFund) throws NotFoundException {
        RealStateFund realStateFund = find(id);
        return realStateFundRepository.save(realStateFund);
    }

    public void delete(Long id) throws NotFoundException {
        RealStateFund realStateFund = find(id);
        realStateFundRepository.delete(realStateFund);
    }
}

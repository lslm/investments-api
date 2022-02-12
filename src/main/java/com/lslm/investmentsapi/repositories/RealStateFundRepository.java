package com.lslm.investmentsapi.repositories;

import com.lslm.investmentsapi.models.RealStateFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealStateFundRepository extends JpaRepository<RealStateFund, Long> {}

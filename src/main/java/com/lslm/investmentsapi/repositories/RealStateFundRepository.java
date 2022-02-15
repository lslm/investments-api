package com.lslm.investmentsapi.repositories;

import com.lslm.investmentsapi.models.RealStateFundInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealStateFundRepository extends JpaRepository<RealStateFundInvestment, Long> {}

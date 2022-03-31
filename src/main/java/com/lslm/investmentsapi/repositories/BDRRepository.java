package com.lslm.investmentsapi.repositories;

import com.lslm.investmentsapi.models.BDRInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BDRRepository extends JpaRepository<BDRInvestment, Long> {}

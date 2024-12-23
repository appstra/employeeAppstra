package com.appstra.employee.repository;

import com.appstra.employee.entity.HealthFund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthFundRepository extends JpaRepository<HealthFund,Integer> {
}

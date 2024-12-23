package com.appstra.employee.repository;

import com.appstra.employee.entity.PensionFund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PensionFundRepository extends JpaRepository<PensionFund,Integer> {
}

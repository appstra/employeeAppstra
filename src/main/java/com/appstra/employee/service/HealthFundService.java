package com.appstra.employee.service;

import com.appstra.employee.entity.HealthFund;

import java.util.List;

public interface HealthFundService {
    HealthFund saveHealthFund(HealthFund healthFund);
    HealthFund updateHealthFund(HealthFund healthFund);
    Boolean deleteHealthFund(Integer healthFundId);
    List<HealthFund> listHealthFunds();
    HealthFund getHealthFund(Integer healthFundId);
}

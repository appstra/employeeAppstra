package com.appstra.employee.service;


import com.appstra.employee.entity.CompensationFund;

import java.util.List;

public interface CompensationFundService {
    CompensationFund saveCompensationFund(CompensationFund compensationFund);
    CompensationFund updateCompensationFund(CompensationFund compensationFund);
    Boolean deleteCompensationFund(Integer compensationFundId);
    List<CompensationFund> listCompensationFunds();
    CompensationFund getCompensationFund(Integer compensationFundId);
}

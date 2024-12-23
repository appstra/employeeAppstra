package com.appstra.employee.service;

import java.util.List;
import com.appstra.employee.entity.PensionFund;

public interface PensionFundService {
    PensionFund savePensionFund(PensionFund pensionFund);
    PensionFund updatePensionFund(PensionFund pensionFund);
    Boolean deletePensionFund(Integer pensionFundId);
    List<PensionFund> listPensionFunds();
    PensionFund getPensionFund(Integer pensionFundId);
}

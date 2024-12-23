package com.appstra.employee.service;

import com.appstra.employee.entity.Bank;

import java.util.List;

public interface BankService {
    Bank saveBank(Bank bank);
    Bank updateBank(Bank bank);
    Boolean deleteBank(Integer bankId);
    List<Bank> listBanks();
    Bank getBank(Integer bankId);
}

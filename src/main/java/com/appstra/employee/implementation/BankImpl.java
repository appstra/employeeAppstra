package com.appstra.employee.implementation;

import com.appstra.employee.entity.Bank;
import com.appstra.employee.repository.BankRepository;
import com.appstra.employee.service.BankService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BankImpl implements BankService {
    private final BankRepository bankRepository;

    public BankImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank saveBank(Bank bank) {
        bank.setBankCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        bank.setBankEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return bankRepository.save(bank);
    }

    @Override
    public Bank updateBank(Bank bank) {
        Bank existingBank = bankRepository.findById(bank.getBankId())
                .orElseThrow(() -> new IllegalArgumentException("El banco no existe: " + bank.getBankId()));
        bank.setBankCreationDate(existingBank.getBankCreationDate());
        bank.setBankEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return bankRepository.save(bank);
    }

    @Override
    public Boolean deleteBank(Integer bankId) {
        if (bankRepository.existsById(bankId)) {
            bankRepository.deleteById(bankId);
            return true;
        }
        return false;
    }

    @Override
    public List<Bank> listBanks() {
        return bankRepository.findAll();
    }

    @Override
    public Bank getBank(Integer bankId) {
        return bankRepository.findById(bankId)
                .orElseThrow(() -> new NoSuchElementException("El banco con el ID: " + bankId + " no se encontró"));
    }
}

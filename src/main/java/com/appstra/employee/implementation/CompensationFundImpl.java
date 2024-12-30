package com.appstra.employee.implementation;
import com.appstra.employee.entity.CompensationFund;
import com.appstra.employee.repository.CompensationFundRepository;
import com.appstra.employee.service.CompensationFundService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CompensationFundImpl implements CompensationFundService {
    private final CompensationFundRepository compensationFundRepository;

    public CompensationFundImpl(CompensationFundRepository compensationFundRepository) {
        this.compensationFundRepository = compensationFundRepository;
    }

    @Override
    public CompensationFund saveCompensationFund(CompensationFund compensationFund) {
        compensationFund.setCompensationFundCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        compensationFund.setCompensationFundEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return compensationFundRepository.save(compensationFund);
    }

    @Override
    public CompensationFund updateCompensationFund(CompensationFund compensationFund) {
        CompensationFund existingCompensationFund = compensationFundRepository.findById(compensationFund.getCompensationFundId())
                .orElseThrow(() -> new IllegalArgumentException("El fondo de compensación no existe: " + compensationFund.getCompensationFundId()));
        compensationFund.setCompensationFundCreationDate(existingCompensationFund.getCompensationFundCreationDate());
        compensationFund.setCompensationFundEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return compensationFundRepository.save(compensationFund);
    }

    @Override
    public Boolean deleteCompensationFund(Integer compensationFundId) {
        if (compensationFundRepository.existsById(compensationFundId)) {
            compensationFundRepository.deleteById(compensationFundId);
            return true;
        }
        return false;
    }

    @Override
    public List<CompensationFund> listCompensationFunds() {
        return compensationFundRepository.findAll();
    }

    @Override
    public CompensationFund getCompensationFund(Integer compensationFundId) {
        return compensationFundRepository.findById(compensationFundId)
                .orElseThrow(() -> new NoSuchElementException("El fondo de compensación con el ID: " + compensationFundId + " no se encontró"));
    }
}


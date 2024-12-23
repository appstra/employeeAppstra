package com.appstra.employee.implementation;

import com.appstra.employee.entity.HealthFund;
import com.appstra.employee.repository.HealthFundRepository;
import com.appstra.employee.service.HealthFundService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HealthFundImpl implements HealthFundService {
    private final HealthFundRepository healthFundRepository;

    public HealthFundImpl(HealthFundRepository healthFundRepository) {
        this.healthFundRepository = healthFundRepository;
    }

    @Override
    public HealthFund saveHealthFund(HealthFund healthFund) {
        healthFund.setHealthFundCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        healthFund.setHealthFundEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return healthFundRepository.save(healthFund);
    }

    @Override
    public HealthFund updateHealthFund(HealthFund healthFund) {
        HealthFund existingHealthFund = healthFundRepository.findById(healthFund.getHealthFundId())
                .orElseThrow(() -> new IllegalArgumentException("El fondo de salud no existe: " + healthFund.getHealthFundId()));
        healthFund.setHealthFundCreationDate(existingHealthFund.getHealthFundCreationDate());
        healthFund.setHealthFundEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return healthFundRepository.save(healthFund);
    }

    @Override
    public Boolean deleteHealthFund(Integer healthFundId) {
        if (healthFundRepository.existsById(healthFundId)) {
            healthFundRepository.deleteById(healthFundId);
            return true;
        }
        return false;
    }

    @Override
    public List<HealthFund> listHealthFunds() {
        return healthFundRepository.findAll();
    }

    @Override
    public HealthFund getHealthFund(Integer healthFundId) {
        return healthFundRepository.findById(healthFundId)
                .orElseThrow(() -> new NoSuchElementException("El fondo de salud con el ID: " + healthFundId + " no se encontró"));
    }
}

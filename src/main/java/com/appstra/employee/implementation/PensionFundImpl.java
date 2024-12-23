package com.appstra.employee.implementation;

import com.appstra.employee.entity.PensionFund;
import com.appstra.employee.repository.PensionFundRepository;
import com.appstra.employee.service.PensionFundService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PensionFundImpl implements PensionFundService {
    private final PensionFundRepository pensionFundRepository;

    public PensionFundImpl(PensionFundRepository pensionFundRepository) {
        this.pensionFundRepository = pensionFundRepository;
    }

    @Override
    public PensionFund savePensionFund(PensionFund pensionFund) {
        pensionFund.setPensionFundCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        pensionFund.setPensionFundEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return pensionFundRepository.save(pensionFund);
    }

    @Override
    public PensionFund updatePensionFund(PensionFund pensionFund) {
        PensionFund existingPensionFund = pensionFundRepository.findById(pensionFund.getPensionFundId())
                .orElseThrow(() -> new IllegalArgumentException("El fondo de pensión no existe: " + pensionFund.getPensionFundId()));
        pensionFund.setPensionFundCreationDate(existingPensionFund.getPensionFundCreationDate());
        pensionFund.setPensionFundEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return pensionFundRepository.save(pensionFund);
    }

    @Override
    public Boolean deletePensionFund(Integer pensionFundId) {
        if (pensionFundRepository.existsById(pensionFundId)) {
            pensionFundRepository.deleteById(pensionFundId);
            return true;
        }
        return false;
    }

    @Override
    public List<PensionFund> listPensionFunds() {
        return pensionFundRepository.findAll();
    }

    @Override
    public PensionFund getPensionFund(Integer pensionFundId) {
        return pensionFundRepository.findById(pensionFundId)
                .orElseThrow(() -> new NoSuchElementException("El fondo de pensión con el ID: " + pensionFundId + " no se encontró"));
    }
}

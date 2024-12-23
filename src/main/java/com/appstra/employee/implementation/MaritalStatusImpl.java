package com.appstra.employee.implementation;

import com.appstra.employee.entity.MaritalStatus;
import com.appstra.employee.repository.MaritalStatusRepository;
import com.appstra.employee.service.MaritalStatusService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MaritalStatusImpl implements MaritalStatusService {
    private final MaritalStatusRepository maritalStatusRepository;

    public MaritalStatusImpl(MaritalStatusRepository maritalStatusRepository) {
        this.maritalStatusRepository = maritalStatusRepository;
    }

    @Override
    public MaritalStatus saveMaritalStatus(MaritalStatus maritalStatus) {
        maritalStatus.setMaritalStatusCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        maritalStatus.setMaritalStatusEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return maritalStatusRepository.save(maritalStatus);
    }

    @Override
    public MaritalStatus updateMaritalStatus(MaritalStatus maritalStatus) {
        MaritalStatus existingMaritalStatus = maritalStatusRepository.findById(maritalStatus.getMaritalStatusId())
                .orElseThrow(() -> new IllegalArgumentException("El estado civil no existe: " + maritalStatus.getMaritalStatusId()));
        maritalStatus.setMaritalStatusCreationDate(existingMaritalStatus.getMaritalStatusCreationDate());
        maritalStatus.setMaritalStatusEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return maritalStatusRepository.save(maritalStatus);
    }

    @Override
    public Boolean deleteMaritalStatus(Integer maritalStatusId) {
        if (maritalStatusRepository.existsById(maritalStatusId)) {
            maritalStatusRepository.deleteById(maritalStatusId);
            return true;
        }
        return false;
    }

    @Override
    public List<MaritalStatus> listMaritalStatuses() {
        return maritalStatusRepository.findAll();
    }

    @Override
    public MaritalStatus getMaritalStatus(Integer maritalStatusId) {
        return maritalStatusRepository.findById(maritalStatusId)
                .orElseThrow(() -> new NoSuchElementException("El estado civil con el ID: " + maritalStatusId + " no se encontró"));
    }
}

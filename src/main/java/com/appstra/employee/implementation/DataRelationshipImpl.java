package com.appstra.employee.implementation;

import com.appstra.employee.entity.DataRelationship;
import com.appstra.employee.repository.DataRelationshipRepository;
import com.appstra.employee.service.DataRelationshipService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DataRelationshipImpl implements DataRelationshipService {
    private final DataRelationshipRepository dataRelationshipRepository;

    public DataRelationshipImpl(DataRelationshipRepository dataRelationshipRepository) {
        this.dataRelationshipRepository = dataRelationshipRepository;
    }

    @Override
    public DataRelationship saveDataRelationship(DataRelationship dataRelationship) {
        dataRelationship.setDataRelationshipCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        dataRelationship.setDataRelationshipEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return dataRelationshipRepository.save(dataRelationship);
    }

    @Override
    public DataRelationship updateDataRelationship(DataRelationship dataRelationship) {
        DataRelationship existingDataRelationship = dataRelationshipRepository.findById(dataRelationship.getDataRelationshipId())
                .orElseThrow(() -> new IllegalArgumentException("El vínculo de datos no existe: " + dataRelationship.getDataRelationshipId()));
        dataRelationship.setDataRelationshipCreationDate(existingDataRelationship.getDataRelationshipCreationDate());
        dataRelationship.setDataRelationshipEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return dataRelationshipRepository.save(dataRelationship);
    }

    @Override
    public Boolean deleteDataRelationship(Integer dataRelationshipId) {
        if (dataRelationshipRepository.existsById(dataRelationshipId)) {
            dataRelationshipRepository.deleteById(dataRelationshipId);
            return true;
        }
        return false;
    }

    @Override
    public List<DataRelationship> listDataRelationships() {
        return dataRelationshipRepository.findAll();
    }

    @Override
    public DataRelationship getDataRelationship(Integer dataRelationshipId) {
        return dataRelationshipRepository.findById(dataRelationshipId)
                .orElseThrow(() -> new NoSuchElementException("El vínculo de datos con el ID: " + dataRelationshipId + " no se encontró"));
    }
}


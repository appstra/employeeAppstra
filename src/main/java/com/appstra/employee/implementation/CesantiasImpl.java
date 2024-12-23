package com.appstra.employee.implementation;

import com.appstra.employee.entity.Cesantias;
import com.appstra.employee.repository.CesantiasRepository;
import com.appstra.employee.service.CesantiasService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CesantiasImpl implements CesantiasService {
    private final CesantiasRepository cesantiasRepository;

    public CesantiasImpl(CesantiasRepository cesantiasRepository) {
        this.cesantiasRepository = cesantiasRepository;
    }

    @Override
    public Cesantias saveCesantias(Cesantias cesantias) {
        cesantias.setCesantiasCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        cesantias.setCesantiasEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return cesantiasRepository.save(cesantias);
    }

    @Override
    public Cesantias updateCesantias(Cesantias cesantias) {
        Cesantias existingCesantias = cesantiasRepository.findById(cesantias.getCesantiasId())
                .orElseThrow(() -> new IllegalArgumentException("Las cesantías no existen: " + cesantias.getCesantiasId()));
        cesantias.setCesantiasCreationDate(existingCesantias.getCesantiasCreationDate());
        cesantias.setCesantiasEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return cesantiasRepository.save(cesantias);
    }

    @Override
    public Boolean deleteCesantias(Integer cesantiasId) {
        if (cesantiasRepository.existsById(cesantiasId)) {
            cesantiasRepository.deleteById(cesantiasId);
            return true;
        }
        return false;
    }

    @Override
    public List<Cesantias> listCesantias() {
        return cesantiasRepository.findAll();
    }

    @Override
    public Cesantias getCesantias(Integer cesantiasId) {
        return cesantiasRepository.findById(cesantiasId)
                .orElseThrow(() -> new NoSuchElementException("Las cesantías con el ID: " + cesantiasId + " no se encontraron"));
    }
}


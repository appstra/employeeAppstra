package com.appstra.employee.implementation;

import com.appstra.employee.entity.Arl;
import com.appstra.employee.repository.ArlRepository;
import com.appstra.employee.service.ArlService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArlImpl implements ArlService {
    private final ArlRepository arlRepository;

    public ArlImpl(ArlRepository arlRepository) {
        this.arlRepository = arlRepository;
    }

    @Override
    public Arl saveArl(Arl arl) {
        arl.setArlCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        arl.setArlEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return arlRepository.save(arl);
    }

    @Override
    public Arl updateArl(Arl arl) {
        Arl existingArl = arlRepository.findById(arl.getArlId())
                .orElseThrow(() -> new IllegalArgumentException("La ARL no existe: " + arl.getArlId()));
        arl.setArlCreationDate(existingArl.getArlCreationDate());
        arl.setArlEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return arlRepository.save(arl);
    }

    @Override
    public Boolean deleteArl(Integer arlId) {
        if (arlRepository.existsById(arlId)) {
            arlRepository.deleteById(arlId);
            return true;
        }
        return false;
    }

    @Override
    public List<Arl> listArls() {
        return arlRepository.findAll();
    }

    @Override
    public Arl getArl(Integer arlId) {
        return arlRepository.findById(arlId)
                .orElseThrow(() -> new NoSuchElementException("La ARL con el ID: " + arlId + " no se encontró"));
    }
}


package com.appstra.employee.implementation;

import com.appstra.employee.entity.DrivingPass;
import com.appstra.employee.repository.DrivingPassRepository;
import com.appstra.employee.service.DrivingPassService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DrivingPassImpl implements DrivingPassService {
    private final DrivingPassRepository drivingPassRepository;

    public DrivingPassImpl(DrivingPassRepository drivingPassRepository) {
        this.drivingPassRepository = drivingPassRepository;
    }

    @Override
    public DrivingPass saveDrivingPass(DrivingPass drivingPass) {
        drivingPass.setDrivingPassCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        drivingPass.setDrivingPassEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return drivingPassRepository.save(drivingPass);
    }

    @Override
    public DrivingPass updateDrivingPass(DrivingPass drivingPass) {
        DrivingPass existingDrivingPass = drivingPassRepository.findById(drivingPass.getDrivingPassId())
                .orElseThrow(() -> new IllegalArgumentException("El pase de conducción no existe: " + drivingPass.getDrivingPassId()));
        drivingPass.setDrivingPassCreationDate(existingDrivingPass.getDrivingPassCreationDate());
        drivingPass.setDrivingPassEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return drivingPassRepository.save(drivingPass);
    }

    @Override
    public Boolean deleteDrivingPass(Integer drivingPassId) {
        if (drivingPassRepository.existsById(drivingPassId)) {
            drivingPassRepository.deleteById(drivingPassId);
            return true;
        }
        return false;
    }

    @Override
    public List<DrivingPass> listDrivingPasses() {
        return drivingPassRepository.findAll();
    }

    @Override
    public DrivingPass getDrivingPass(Integer drivingPassId) {
        return drivingPassRepository.findById(drivingPassId)
                .orElseThrow(() -> new NoSuchElementException("El pase de conducción con el ID: " + drivingPassId + " no se encontró"));
    }
}

package com.appstra.employee.implementation;

import com.appstra.employee.entity.EducationalLevel;
import com.appstra.employee.repository.EducationalLevelRepository;
import com.appstra.employee.service.EducationalLevelService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EducationalLevelImpl implements EducationalLevelService {
    private final EducationalLevelRepository educationalLevelRepository;

    public EducationalLevelImpl(EducationalLevelRepository educationalLevelRepository) {
        this.educationalLevelRepository = educationalLevelRepository;
    }

    @Override
    public EducationalLevel saveEducationalLevel(EducationalLevel educationalLevel) {
        educationalLevel.setEducationalLevelCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        educationalLevel.setEducationalLevelEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return educationalLevelRepository.save(educationalLevel);
    }

    @Override
    public EducationalLevel updateEducationalLevel(EducationalLevel educationalLevel) {
        EducationalLevel existingEducationalLevel = educationalLevelRepository.findById(educationalLevel.getEducationalLevelId())
                .orElseThrow(() -> new IllegalArgumentException("El nivel educativo no existe: " + educationalLevel.getEducationalLevelId()));
        educationalLevel.setEducationalLevelCreationDate(existingEducationalLevel.getEducationalLevelCreationDate());
        educationalLevel.setEducationalLevelEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return educationalLevelRepository.save(educationalLevel);
    }

    @Override
    public Boolean deleteEducationalLevel(Integer educationalLevelId) {
        if (educationalLevelRepository.existsById(educationalLevelId)) {
            educationalLevelRepository.deleteById(educationalLevelId);
            return true;
        }
        return false;
    }

    @Override
    public List<EducationalLevel> listEducationalLevels() {
        return educationalLevelRepository.findAll();
    }

    @Override
    public EducationalLevel getEducationalLevel(Integer educationalLevelId) {
        return educationalLevelRepository.findById(educationalLevelId)
                .orElseThrow(() -> new NoSuchElementException("El nivel educativo con el ID: " + educationalLevelId + " no se encontró"));
    }
}

package com.appstra.employee.service;

import com.appstra.employee.entity.EducationalLevel;

import java.util.List;

public interface EducationalLevelService {
    EducationalLevel saveEducationalLevel(EducationalLevel educationalLevel);
    EducationalLevel updateEducationalLevel(EducationalLevel educationalLevel);
    Boolean deleteEducationalLevel(Integer educationalLevelId);
    List<EducationalLevel> listEducationalLevels();
    EducationalLevel getEducationalLevel(Integer educationalLevelId);
}


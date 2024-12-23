package com.appstra.employee.service;

import java.util.List;
import com.appstra.employee.entity.MaritalStatus;

public interface MaritalStatusService {
    MaritalStatus saveMaritalStatus(MaritalStatus maritalStatus);
    MaritalStatus updateMaritalStatus(MaritalStatus maritalStatus);
    Boolean deleteMaritalStatus(Integer maritalStatusId);
    List<MaritalStatus> listMaritalStatuses();
    MaritalStatus getMaritalStatus(Integer maritalStatusId);
}


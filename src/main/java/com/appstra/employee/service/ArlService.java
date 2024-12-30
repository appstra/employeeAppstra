package com.appstra.employee.service;

import com.appstra.employee.entity.Arl;

import java.util.List;

public interface ArlService {
    Arl saveArl(Arl arl);
    Arl updateArl(Arl arl);
    Boolean deleteArl(Integer arlId);
    List<Arl> listArls();
    Arl getArl(Integer arlId);
}

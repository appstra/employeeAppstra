package com.appstra.employee.service;

import com.appstra.employee.entity.Cesantias;

import java.util.List;

public interface CesantiasService {
    Cesantias saveCesantias(Cesantias cesantias);
    Cesantias updateCesantias(Cesantias cesantias);
    Boolean deleteCesantias(Integer cesantiasId);
    List<Cesantias> listCesantias();
    Cesantias getCesantias(Integer cesantiasId);
}


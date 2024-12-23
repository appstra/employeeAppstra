package com.appstra.employee.service;

import com.appstra.employee.entity.DataRelationship;

import java.util.List;

public interface DataRelationshipService {
    DataRelationship saveDataRelationship(DataRelationship dataRelationship);
    DataRelationship updateDataRelationship(DataRelationship dataRelationship);
    Boolean deleteDataRelationship(Integer dataRelationship);
    List<DataRelationship> listDataRelationships();
    DataRelationship getDataRelationship(Integer dataRelationship);
}


package com.appstra.employee.service;

import com.appstra.employee.entity.DrivingPass;
import java.util.List;

public interface DrivingPassService {
    DrivingPass saveDrivingPass(DrivingPass drivingPass);
    DrivingPass updateDrivingPass(DrivingPass drivingPass);
    Boolean deleteDrivingPass(Integer drivingPassId);
    List<DrivingPass> listDrivingPasses();
    DrivingPass getDrivingPass(Integer drivingPassId);
}

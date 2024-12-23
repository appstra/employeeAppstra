package com.appstra.employee.controller;

import com.appstra.employee.entity.DrivingPass;
import com.appstra.employee.service.DrivingPassService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/DrivingPass")
public class DrivingPassController {
    private final DrivingPassService drivingPassService;

    public DrivingPassController(DrivingPassService drivingPassService) {
        this.drivingPassService = drivingPassService;
    }

    @PostMapping("/savedrivingpass")
    @Operation(summary = "Guardar Licencia de Conducir", description = "Guardar una nueva licencia de conducir asociada a un empleado")
    public ResponseEntity<DrivingPass> saveDrivingPass(@Validated @RequestBody DrivingPass drivingPass) {
        return ResponseEntity.ok(drivingPassService.saveDrivingPass(drivingPass));
    }

    @PutMapping("/updatedrivingpass")
    @Operation(summary = "Actualizar Licencia de Conducir", description = "Actualizar una licencia de conducir existente asociada a un empleado")
    public ResponseEntity<DrivingPass> updateDrivingPass(@Validated @RequestBody DrivingPass drivingPass) {
        return ResponseEntity.ok(drivingPassService.updateDrivingPass(drivingPass));
    }

    @DeleteMapping("/deletedrivingpass/{drivingPassId}")
    @Operation(summary = "Eliminar Licencia de Conducir", description = "Eliminar una licencia de conducir por ID")
    public ResponseEntity<Boolean> deleteDrivingPass(@PathVariable("drivingPassId") Integer drivingPassId) {
        return ResponseEntity.ok(drivingPassService.deleteDrivingPass(drivingPassId));
    }

    @GetMapping("/listdrivingpass")
    @Operation(summary = "Lista de Licencias de Conducir", description = "Obtener la lista de todas las licencias de conducir")
    public ResponseEntity<List<DrivingPass>> listDrivingPass() {
        return ResponseEntity.ok(drivingPassService.listDrivingPasses());
    }

    @GetMapping("/{drivingPassId}")
    @Operation(summary = "Información de Licencia de Conducir", description = "Obtener información de una licencia de conducir por ID")
    public ResponseEntity<DrivingPass> getDrivingPass(@PathVariable("drivingPassId") Integer drivingPassId) {
        return ResponseEntity.ok(drivingPassService.getDrivingPass(drivingPassId));
    }
}

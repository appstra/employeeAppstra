package com.appstra.employee.controller;

import com.appstra.employee.entity.MaritalStatus;
import com.appstra.employee.service.MaritalStatusService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/MaritalStatus")
public class MaritalStatusController {
    private final MaritalStatusService maritalStatusService;

    public MaritalStatusController(MaritalStatusService maritalStatusService) {
        this.maritalStatusService = maritalStatusService;
    }

    @PostMapping("/savemaritalstatus")
    @Operation(summary = "Guardar Estado Civil", description = "Guardar un nuevo estado civil")
    public ResponseEntity<MaritalStatus> saveMaritalStatus(@Validated @RequestBody MaritalStatus maritalStatus) {
        return ResponseEntity.ok(maritalStatusService.saveMaritalStatus(maritalStatus));
    }

    @PutMapping("/updatemaritalstatus")
    @Operation(summary = "Actualizar Estado Civil", description = "Actualizar la información de un estado civil existente")
    public ResponseEntity<MaritalStatus> updateMaritalStatus(@Validated @RequestBody MaritalStatus maritalStatus) {
        return ResponseEntity.ok(maritalStatusService.updateMaritalStatus(maritalStatus));
    }

    @DeleteMapping("/deletemaritalstatus/{maritalStatusId}")
    @Operation(summary = "Eliminar Estado Civil", description = "Eliminar un estado civil por ID")
    public ResponseEntity<Boolean> deleteMaritalStatus(@PathVariable("maritalStatusId") Integer maritalStatusId) {
        return ResponseEntity.ok(maritalStatusService.deleteMaritalStatus(maritalStatusId));
    }

    @GetMapping("/listmaritalstatus")
    @Operation(summary = "Lista de Estados Civiles", description = "Obtener la lista de todos los estados civiles")
    public ResponseEntity<List<MaritalStatus>> listMaritalStatus() {
        return ResponseEntity.ok(maritalStatusService.listMaritalStatuses());
    }

    @GetMapping("/{maritalStatusId}")
    @Operation(summary = "Información del Estado Civil", description = "Obtener información de un estado civil por ID")
    public ResponseEntity<MaritalStatus> getMaritalStatus(@PathVariable("maritalStatusId") Integer maritalStatusId) {
        return ResponseEntity.ok(maritalStatusService.getMaritalStatus(maritalStatusId));
    }
}

package com.appstra.employee.controller;

import com.appstra.employee.entity.HealthFund;
import com.appstra.employee.service.HealthFundService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/HealthFund")
public class HealthFundController {
    private final HealthFundService healthFundService;

    public HealthFundController(HealthFundService healthFundService) {
        this.healthFundService = healthFundService;
    }

    @PostMapping("/savehealthfund")
    @Operation(summary = "Guardar Fondo de Salud", description = "Guardar un nuevo fondo de salud")
    public ResponseEntity<HealthFund> saveHealthFund(@Validated @RequestBody HealthFund healthFund) {
        return ResponseEntity.ok(healthFundService.saveHealthFund(healthFund));
    }

    @PutMapping("/updatehealthfund")
    @Operation(summary = "Actualizar Fondo de Salud", description = "Actualizar la información de un fondo de salud existente")
    public ResponseEntity<HealthFund> updateHealthFund(@Validated @RequestBody HealthFund healthFund) {
        return ResponseEntity.ok(healthFundService.updateHealthFund(healthFund));
    }

    @DeleteMapping("/deletehealthfund/{healthFundId}")
    @Operation(summary = "Eliminar Fondo de Salud", description = "Eliminar un fondo de salud por ID")
    public ResponseEntity<Boolean> deleteHealthFund(@PathVariable("healthFundId") Integer healthFundId) {
        return ResponseEntity.ok(healthFundService.deleteHealthFund(healthFundId));
    }

    @GetMapping("/listhealthfund")
    @Operation(summary = "Lista de Fondos de Salud", description = "Obtener la lista de todos los fondos de salud")
    public ResponseEntity<List<HealthFund>> listHealthFund() {
        return ResponseEntity.ok(healthFundService.listHealthFunds());
    }

    @GetMapping("/{healthFundId}")
    @Operation(summary = "Información del Fondo de Salud", description = "Obtener información de un fondo de salud por ID")
    public ResponseEntity<HealthFund> getHealthFund(@PathVariable("healthFundId") Integer healthFundId) {
        return ResponseEntity.ok(healthFundService.getHealthFund(healthFundId));
    }
}

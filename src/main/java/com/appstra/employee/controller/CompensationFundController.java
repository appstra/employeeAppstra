package com.appstra.employee.controller;

import com.appstra.employee.entity.CompensationFund;
import com.appstra.employee.service.CompensationFundService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/CompensationFund")
public class CompensationFundController {
    private final CompensationFundService compensationFundService;

    public CompensationFundController(CompensationFundService compensationFundService) {
        this.compensationFundService = compensationFundService;
    }

    @PostMapping("/savecompensationfund")
    @Operation(summary = "Guardar Fondo de Compensación", description = "Guardar nueva información de fondo de compensación")
    public ResponseEntity<CompensationFund> saveCompensationFund(@Validated @RequestBody CompensationFund compensationFund) {
        return ResponseEntity.ok(compensationFundService.saveCompensationFund(compensationFund));
    }

    @PutMapping("/updatecompensationfund")
    @Operation(summary = "Actualizar Fondo de Compensación", description = "Actualizar información de un fondo de compensación existente")
    public ResponseEntity<CompensationFund> updateCompensationFund(@Validated @RequestBody CompensationFund compensationFund) {
        return ResponseEntity.ok(compensationFundService.updateCompensationFund(compensationFund));
    }

    @DeleteMapping("/deletecompensationfund/{compensationFundId}")
    @Operation(summary = "Eliminar Fondo de Compensación", description = "Eliminar un fondo de compensación por ID")
    public ResponseEntity<Boolean> deleteCompensationFund(@PathVariable("compensationFundId") Integer compensationFundId) {
        return ResponseEntity.ok(compensationFundService.deleteCompensationFund(compensationFundId));
    }

    @GetMapping("/listcompensationfunds")
    @Operation(summary = "Lista de Fondos de Compensación", description = "Obtener lista de todos los fondos de compensación")
    public ResponseEntity<List<CompensationFund>> listCompensationFunds() {
        return ResponseEntity.ok(compensationFundService.listCompensationFunds());
    }

    @GetMapping("/{compensationFundId}")
    @Operation(summary = "Información del Fondo de Compensación", description = "Obtener información de un fondo de compensación por ID")
    public ResponseEntity<CompensationFund> getCompensationFund(@PathVariable("compensationFundId") Integer compensationFundId) {
        return ResponseEntity.ok(compensationFundService.getCompensationFund(compensationFundId));
    }
}


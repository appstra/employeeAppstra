package com.appstra.employee.controller;

import com.appstra.employee.entity.PensionFund;
import com.appstra.employee.service.PensionFundService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/PensionFund")
public class PensionFundController {
    private final PensionFundService pensionFundService;

    public PensionFundController(PensionFundService pensionFundService) {
        this.pensionFundService = pensionFundService;
    }

    @PostMapping("/savepensionfund")
    @Operation(summary = "Guardar Fondo de Pensiones", description = "Guardar un nuevo fondo de pensiones")
    public ResponseEntity<PensionFund> savePensionFund(@Validated @RequestBody PensionFund pensionFund) {
        return ResponseEntity.ok(pensionFundService.savePensionFund(pensionFund));
    }

    @PutMapping("/updatepensionfund")
    @Operation(summary = "Actualizar Fondo de Pensiones", description = "Actualizar la información de un fondo de pensiones existente")
    public ResponseEntity<PensionFund> updatePensionFund(@Validated @RequestBody PensionFund pensionFund) {
        return ResponseEntity.ok(pensionFundService.updatePensionFund(pensionFund));
    }

    @DeleteMapping("/deletepensionfund/{pensionFundId}")
    @Operation(summary = "Eliminar Fondo de Pensiones", description = "Eliminar un fondo de pensiones por ID")
    public ResponseEntity<Boolean> deletePensionFund(@PathVariable("pensionFundId") Integer pensionFundId) {
        return ResponseEntity.ok(pensionFundService.deletePensionFund(pensionFundId));
    }

    @GetMapping("/listpensionfund")
    @Operation(summary = "Lista de Fondos de Pensiones", description = "Obtener la lista de todos los fondos de pensiones")
    public ResponseEntity<List<PensionFund>> listPensionFund() {
        return ResponseEntity.ok(pensionFundService.listPensionFunds());
    }

    @GetMapping("/{pensionFundId}")
    @Operation(summary = "Información del Fondo de Pensiones", description = "Obtener información de un fondo de pensiones por ID")
    public ResponseEntity<PensionFund> getPensionFund(@PathVariable("pensionFundId") Integer pensionFundId) {
        return ResponseEntity.ok(pensionFundService.getPensionFund(pensionFundId));
    }
}

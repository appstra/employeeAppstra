package com.appstra.employee.controller;

import com.appstra.employee.entity.DataRelationship;
import com.appstra.employee.service.DataRelationshipService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/DataRelationship")
public class DataRelationshipController {
    private final DataRelationshipService dataRelationshipService;

    public DataRelationshipController(DataRelationshipService dataRelationshipService) {
        this.dataRelationshipService = dataRelationshipService;
    }

    @PostMapping("/savedatarelationship")
    @Operation(summary = "Guardar Relación", description = "Guardar un nuevo registro de relación")
    public ResponseEntity<DataRelationship> saveDataRelationship(@Validated @RequestBody DataRelationship dataRelationship) {
        return ResponseEntity.ok(dataRelationshipService.saveDataRelationship(dataRelationship));
    }

    @PutMapping("/updatedatarelationship")
    @Operation(summary = "Actualizar Relación", description = "Actualizar un registro existente de relación")
    public ResponseEntity<DataRelationship> updateDataRelationship(@Validated @RequestBody DataRelationship dataRelationship) {
        return ResponseEntity.ok(dataRelationshipService.updateDataRelationship(dataRelationship));
    }

    @DeleteMapping("/deletedatarelationship/{dataRelationshipId}")
    @Operation(summary = "Eliminar Relación", description = "Eliminar un registro de relación por ID")
    public ResponseEntity<Boolean> deleteDataRelationship(@PathVariable("dataRelationshipId") Integer dataRelationshipId) {
        return ResponseEntity.ok(dataRelationshipService.deleteDataRelationship(dataRelationshipId));
    }

    @GetMapping("/listdatarelationship")
    @Operation(summary = "Lista de Relaciones", description = "Obtener la lista de todas las relaciones")
    public ResponseEntity<List<DataRelationship>> listDataRelationship() {
        return ResponseEntity.ok(dataRelationshipService.listDataRelationships());
    }

    @GetMapping("/{dataRelationshipId}")
    @Operation(summary = "Información de Relación", description = "Obtener información de relación por ID")
    public ResponseEntity<DataRelationship> getDataRelationship(@PathVariable("dataRelationshipId") Integer dataRelationshipId) {
        return ResponseEntity.ok(dataRelationshipService.getDataRelationship(dataRelationshipId));
    }
}


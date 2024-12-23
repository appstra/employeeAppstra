package com.appstra.employee.controller;

import com.appstra.employee.entity.Cesantias;
import com.appstra.employee.service.CesantiasService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Cesantias")
public class CesantiasController {
    private final CesantiasService cesantiasService;

    public CesantiasController(CesantiasService cesantiasService) {
        this.cesantiasService = cesantiasService;
    }

    @PostMapping("/savecesantias")
    @Operation(summary = "Guardar Cesantías", description = "Guardar un nuevo registro de cesantías")
    public ResponseEntity<Cesantias> saveCesantias(@Validated @RequestBody Cesantias cesantias) {
        return ResponseEntity.ok(cesantiasService.saveCesantias(cesantias));
    }

    @PutMapping("/updatecesantias")
    @Operation(summary = "Actualizar Cesantías", description = "Actualizar un registro existente de cesantías")
    public ResponseEntity<Cesantias> updateCesantias(@Validated @RequestBody Cesantias cesantias) {
        return ResponseEntity.ok(cesantiasService.updateCesantias(cesantias));
    }

    @DeleteMapping("/deletecesantias/{cesantiasId}")
    @Operation(summary = "Eliminar Cesantías", description = "Eliminar un registro de cesantías por ID")
    public ResponseEntity<Boolean> deleteCesantias(@PathVariable("cesantiasId") Integer cesantiasId) {
        return ResponseEntity.ok(cesantiasService.deleteCesantias(cesantiasId));
    }

    @GetMapping("/listcesantias")
    @Operation(summary = "Lista de Cesantías", description = "Obtener la lista de todas las cesantías")
    public ResponseEntity<List<Cesantias>> listCesantias() {
        return ResponseEntity.ok(cesantiasService.listCesantias());
    }

    @GetMapping("/{cesantiasId}")
    @Operation(summary = "Información de Cesantías", description = "Obtener información de cesantías por ID")
    public ResponseEntity<Cesantias> getCesantias(@PathVariable("cesantiasId") Integer cesantiasId) {
        return ResponseEntity.ok(cesantiasService.getCesantias(cesantiasId));
    }
}


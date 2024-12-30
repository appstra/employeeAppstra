package com.appstra.employee.controller;

import com.appstra.employee.entity.Arl;
import com.appstra.employee.service.ArlService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Arl")
public class ArlController {
    private final ArlService arlService;

    public ArlController(ArlService arlService) {
        this.arlService = arlService;
    }

    @PostMapping("/savearl")
    @Operation(summary = "Guardar ARL", description = "Guardar nueva información de ARL")
    public ResponseEntity<Arl> saveArl(@Validated @RequestBody Arl arl) {
        return ResponseEntity.ok(arlService.saveArl(arl));
    }

    @PutMapping("/updatearl")
    @Operation(summary = "Actualizar ARL", description = "Actualizar información de una ARL existente")
    public ResponseEntity<Arl> updateArl(@Validated @RequestBody Arl arl) {
        return ResponseEntity.ok(arlService.updateArl(arl));
    }

    @DeleteMapping("/deletearl/{arlId}")
    @Operation(summary = "Eliminar ARL", description = "Eliminar una ARL por ID")
    public ResponseEntity<Boolean> deleteArl(@PathVariable("arlId") Integer arlId) {
        return ResponseEntity.ok(arlService.deleteArl(arlId));
    }

    @GetMapping("/listarls")
    @Operation(summary = "Lista de ARLs", description = "Obtener lista de todas las ARLs")
    public ResponseEntity<List<Arl>> listArls() {
        return ResponseEntity.ok(arlService.listArls());
    }

    @GetMapping("/{arlId}")
    @Operation(summary = "Información de la ARL", description = "Obtener información de una ARL por ID")
    public ResponseEntity<Arl> getArl(@PathVariable("arlId") Integer arlId) {
        return ResponseEntity.ok(arlService.getArl(arlId));
    }
}


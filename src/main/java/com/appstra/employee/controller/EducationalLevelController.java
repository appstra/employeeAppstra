package com.appstra.employee.controller;

import com.appstra.employee.entity.EducationalLevel;
import com.appstra.employee.service.EducationalLevelService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/EducationalLevel")
public class EducationalLevelController {
    private final EducationalLevelService educationalLevelService;

    public EducationalLevelController(EducationalLevelService educationalLevelService) {
        this.educationalLevelService = educationalLevelService;
    }

    @PostMapping("/saveeducationallevel")
    @Operation(summary = "Guardar Nivel Educativo", description = "Guardar un nuevo nivel educativo asociado a un empleado")
    public ResponseEntity<EducationalLevel> saveEducationalLevel(@Validated @RequestBody EducationalLevel educationalLevel) {
        return ResponseEntity.ok(educationalLevelService.saveEducationalLevel(educationalLevel));
    }

    @PutMapping("/updateeducationallevel")
    @Operation(summary = "Actualizar Nivel Educativo", description = "Actualizar un nivel educativo existente asociado a un empleado")
    public ResponseEntity<EducationalLevel> updateEducationalLevel(@Validated @RequestBody EducationalLevel educationalLevel) {
        return ResponseEntity.ok(educationalLevelService.updateEducationalLevel(educationalLevel));
    }

    @DeleteMapping("/deleteeducationallevel/{educationalLevelId}")
    @Operation(summary = "Eliminar Nivel Educativo", description = "Eliminar un nivel educativo por ID")
    public ResponseEntity<Boolean> deleteEducationalLevel(@PathVariable("educationalLevelId") Integer educationalLevelId) {
        return ResponseEntity.ok(educationalLevelService.deleteEducationalLevel(educationalLevelId));
    }

    @GetMapping("/listeducationallevel")
    @Operation(summary = "Lista de Niveles Educativos", description = "Obtener la lista de todos los niveles educativos")
    public ResponseEntity<List<EducationalLevel>> listEducationalLevel() {
        return ResponseEntity.ok(educationalLevelService.listEducationalLevels());
    }

    @GetMapping("/{educationalLevelId}")
    @Operation(summary = "Información de Nivel Educativo", description = "Obtener información de un nivel educativo por ID")
    public ResponseEntity<EducationalLevel> getEducationalLevel(@PathVariable("educationalLevelId") Integer educationalLevelId) {
        return ResponseEntity.ok(educationalLevelService.getEducationalLevel(educationalLevelId));
    }
}


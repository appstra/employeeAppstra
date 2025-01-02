package com.appstra.employee.controller;

import com.appstra.employee.entity.RoleTypeDocument;
import com.appstra.employee.service.RoleTypeDocumentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roletypedocument")
public class RoleTypeDocumentController {

    private final RoleTypeDocumentService roleTypeDocumentService;

    public RoleTypeDocumentController(RoleTypeDocumentService roleTypeDocumentService) {
        this.roleTypeDocumentService = roleTypeDocumentService;
    }

    @PostMapping("/saveroletypedocument")
    @Operation(summary = "Guardar Tipo de Rol documento", description = "Guardar un nuevo Tipo de Rol documento")
    public ResponseEntity<RoleTypeDocument> saveRoleTypeDocument(@Validated @RequestBody RoleTypeDocument roleTypeDocument) {
        return ResponseEntity.ok(roleTypeDocumentService.saveRoleTypeDocument(roleTypeDocument));
    }

    @PutMapping("/updateroletypedocument")
    @Operation(summary = "Actualizar Tipo de Rol documento", description = "Actualizar la información de un Tipo de Rol documento existente")
    public ResponseEntity<RoleTypeDocument> updateRoleTypeDocument(@Validated @RequestBody RoleTypeDocument roleTypeDocument) {
        return ResponseEntity.ok(roleTypeDocumentService.updateRoleTypeDocument(roleTypeDocument));
    }

    @DeleteMapping("/deleteroletypedocument/{roleTypeDocumentId}")
    @Operation(summary = "Eliminar Tipo de Rol documento", description = "Eliminar un Tipo de Rol documento por ID")
    public ResponseEntity<Boolean> deleteRoleTypeDocument(@PathVariable("roleTypeDocumentId") Integer roleTypeDocumentId) {
        return ResponseEntity.ok(roleTypeDocumentService.deleteRoleTypeDocument(roleTypeDocumentId));
    }

    @GetMapping("/listroletypedocument")
    @Operation(summary = "Lista de Tipo de Rol documento", description = "Obtener la lista de todos los tipos de Tipo de Rol documento")
    public ResponseEntity<List<RoleTypeDocument>> listRoleTypeDocuments() {
        return ResponseEntity.ok(roleTypeDocumentService.listRoleTypeDocuments());
    }
}


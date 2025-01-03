package com.appstra.employee.controller;

import com.appstra.employee.entity.DocumentGroup;
import com.appstra.employee.service.DocumentGroupService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/documentgroup")
public class DocumentGroupController {

    private final DocumentGroupService documentGroupService;

    public DocumentGroupController(DocumentGroupService documentGroupService) {
        this.documentGroupService = documentGroupService;
    }

    @PostMapping("/savedocumentgroup")
    @Operation(summary = "Guardar Grupo de Documentos", description = "Guardar un nuevo grupo de documentos")
    public ResponseEntity<DocumentGroup> saveDocumentGroup(@Validated @RequestBody DocumentGroup documentGroup) {
        return ResponseEntity.ok(documentGroupService.saveDocumentGroup(documentGroup));
    }

    @PutMapping("/updatedocumentgroup")
    @Operation(summary = "Actualizar Grupo de Documentos", description = "Actualizar la información de un grupo de documentos existente")
    public ResponseEntity<DocumentGroup> updateDocumentGroup(@Validated @RequestBody DocumentGroup documentGroup) {
        return ResponseEntity.ok(documentGroupService.updateDocumentGroup(documentGroup));
    }

    @DeleteMapping("/deletedocumentgroup/{documentGroupId}")
    @Operation(summary = "Eliminar Grupo de Documentos", description = "Eliminar un grupo de documentos por ID")
    public ResponseEntity<Boolean> deleteDocumentGroup(@PathVariable("documentGroupId") Integer documentGroupId) {
        return ResponseEntity.ok(documentGroupService.deleteDocumentGroup(documentGroupId));
    }

    @GetMapping("/listdocumentgroups")
    @Operation(summary = "Lista de Grupos de Documentos", description = "Obtener la lista de todos los grupos de documentos")
    public ResponseEntity<List<DocumentGroup>> listDocumentGroups() {
        return ResponseEntity.ok(documentGroupService.listDocumentGroups());
    }

    @GetMapping("/{documentGroupId}")
    @Operation(summary = "Información del Grupo de Documentos", description = "Obtener información de un grupo de documentos por ID")
    public ResponseEntity<DocumentGroup> getDocumentGroup(@PathVariable("documentGroupId") Integer documentGroupId) {
        return ResponseEntity.ok(documentGroupService.getDocumentGroup(documentGroupId));
    }
}


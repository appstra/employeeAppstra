package com.appstra.employee.controller;

import com.appstra.employee.entity.TypeDocuments;
import com.appstra.employee.service.TypeDocumentsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/typedocument")
public class TypeDocumentsController {

    private final TypeDocumentsService typeDocumentService;

    public TypeDocumentsController(TypeDocumentsService typeDocumentService) {
        this.typeDocumentService = typeDocumentService;
    }

    @PostMapping("/savetypedocument")
    @Operation(summary = "Guardar Tipo de Documento", description = "Guardar un nuevo tipo de documento")
    public ResponseEntity<TypeDocuments> saveTypeDocument(@Validated @RequestBody TypeDocuments typeDocument) {
        return ResponseEntity.ok(typeDocumentService.saveTypeDocuments(typeDocument));
    }

    @PutMapping("/updatetypedocument")
    @Operation(summary = "Actualizar Tipo de Documento", description = "Actualizar la información de un tipo de documento existente")
    public ResponseEntity<TypeDocuments> updateTypeDocument(@Validated @RequestBody TypeDocuments typeDocument) {
        return ResponseEntity.ok(typeDocumentService.updateTypeDocuments(typeDocument));
    }

    @DeleteMapping("/deletetypedocument/{typeDocumentId}")
    @Operation(summary = "Eliminar Tipo de Documento", description = "Eliminar un tipo de documento por ID")
    public ResponseEntity<Boolean> deleteTypeDocument(@PathVariable("typeDocumentId") Integer typeDocumentId) {
        return ResponseEntity.ok(typeDocumentService.deleteTypeDocuments(typeDocumentId));
    }

    @GetMapping("/listtypedocument")
    @Operation(summary = "Lista de Tipos de Documento", description = "Obtener la lista de todos los tipos de documentos")
    public ResponseEntity<List<TypeDocuments>> listTypeDocuments() {
        return ResponseEntity.ok(typeDocumentService.listTypeDocuments());
    }

    @GetMapping("/{typeDocumentId}")
    @Operation(summary = "Información del Tipo de Documento", description = "Obtener información de un tipo de documento por ID")
    public ResponseEntity<TypeDocuments> getTypeDocument(@PathVariable("typeDocumentId") Integer typeDocumentId) {
        return ResponseEntity.ok(typeDocumentService.getTypeDocuments(typeDocumentId));
    }

    @GetMapping("/listtypedocumentrole/{roleId}")
    @Operation(summary = "listar documento por roleId", description = "listar documento por roleId")
    public ResponseEntity<List<TypeDocuments>> deleteRoleTypeDocument(@PathVariable("roleId") Integer roleId) {
        return ResponseEntity.ok(typeDocumentService.listTypeDocumentsRoleId(roleId));
    }
}

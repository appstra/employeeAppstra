package com.appstra.employee.controller;

import com.appstra.employee.dto.DocumentEmployeeLoadedDTO;
import com.appstra.employee.entity.DocumentsEmployee;
import com.appstra.employee.service.DocumentsEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/DocumentsEmployee")
public class DocumentsEmployeeController {
    private final DocumentsEmployeeService documentsEmployeeService;

    public DocumentsEmployeeController(DocumentsEmployeeService documentsEmployeeService) {
        this.documentsEmployeeService = documentsEmployeeService;
    }

    @PostMapping(value = "/savedocumentsemployee", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Guardar Documento de Empleado", description = "Guardar un nuevo documento asociado a un empleado")
    public ResponseEntity<DocumentsEmployee> saveDocumentsEmployee(
            @RequestPart("document") MultipartFile document,
            @RequestPart("documentsEmployee") DocumentsEmployee documentsEmployee) {
        return ResponseEntity.ok(documentsEmployeeService.saveDocumentsEmployee(document, documentsEmployee));
    }

    @PutMapping("/updatedocumentsemployee")
    @Operation(summary = "Actualizar Documento de Empleado", description = "Actualizar un documento existente asociado a un empleado")
    public ResponseEntity<DocumentsEmployee> updateDocumentsEmployee(@Validated @RequestBody DocumentsEmployee documentsEmployee) {
        return ResponseEntity.ok(documentsEmployeeService.updateDocumentsEmployee(documentsEmployee));
    }

    @DeleteMapping("/deletedocumentsemployee/{documentsEmployeeId}")
    @Operation(summary = "Eliminar Documento de Empleado", description = "Eliminar un documento de empleado por ID")
    public ResponseEntity<Boolean> deleteDocumentsEmployee(@PathVariable("documentsEmployeeId") Integer documentsEmployeeId) {
        return ResponseEntity.ok(documentsEmployeeService.deleteDocumentsEmployee(documentsEmployeeId));
    }

    @GetMapping("/listdocumentsemployee")
    @Operation(summary = "Lista de Documentos de Empleados", description = "Obtener la lista de todos los documentos de empleados")
    public ResponseEntity<List<DocumentsEmployee>> listDocumentsEmployee() {
        return ResponseEntity.ok(documentsEmployeeService.listDocumentsEmployees());
    }

    @GetMapping("/{employeeId}")
    @Operation(summary = "Información de Documento de Empleado", description = "Obtener información de un documento de empleado por ID")
    public ResponseEntity<List<DocumentsEmployee> > getDocumentsEmployee(@PathVariable("employeeId") Integer employeeId) {
        return ResponseEntity.ok(documentsEmployeeService.getDocumentsEmployee(employeeId));
    }

    @GetMapping("loaded/{employeeId}")
    @Operation(summary = "Información de Documento de Empleado cargados", description = "Obtener información de un documento de empleado cargados por ID")
    public ResponseEntity<List<DocumentEmployeeLoadedDTO> > getDocumentsEmployeeLoaded(@PathVariable("employeeId") Integer employeeId) {
        return ResponseEntity.ok(documentsEmployeeService.getDocumentsEmployeeLoaded(employeeId));
    }

}

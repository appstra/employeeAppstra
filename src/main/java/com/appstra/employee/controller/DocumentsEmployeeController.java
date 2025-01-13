package com.appstra.employee.controller;

import com.appstra.employee.entity.DocumentsEmployee;
import com.appstra.employee.entity.TypeDocuments;
import com.appstra.employee.service.DocumentsEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    @Operation(summary = "Lista de documentos faltantes", description = "obtiene los documentos que le falta por cargar")
    public ResponseEntity<List<TypeDocuments> > getDocumentsEmployeeLoaded(@PathVariable("employeeId") Integer employeeId) {
        return ResponseEntity.ok(documentsEmployeeService.getDocumentsEmployeeLoaded(employeeId));
    }

    @GetMapping("downloadDocument/{documentsEmployeeId}")
    @Operation(summary = "Descargar Documentos", description = "Descargar Documentos empleado")
    public ResponseEntity<Resource> downloadDocument(@PathVariable("documentsEmployeeId") Integer documentsEmployeeId) {
        try {
            Resource resource = documentsEmployeeService.downloadDocument(documentsEmployeeId);

            String contentDisposition = "attachment; filename=\"" + resource.getFilename() + "\"";
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("getReportDocuments")
    @Operation(summary = "Reporte de documentos cargados", description = "obtiene el Reporte de documentos cargados")
    public ResponseEntity<List<Map<String, Objects>>> getReportDocuments() {
        return ResponseEntity.ok(documentsEmployeeService.getReportDocuments());
    }

}

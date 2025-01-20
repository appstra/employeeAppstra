package com.appstra.employee.implementation;

import com.appstra.employee.entity.DocumentsEmployee;
import com.appstra.employee.entity.TypeDocuments;
import com.appstra.employee.methods.Functions;
import com.appstra.employee.repository.DocumentsEmployeeRepository;
import com.appstra.employee.service.DocumentsEmployeeService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.Objects;

@Service
public class DocumentsEmployeeImpl implements DocumentsEmployeeService {

    @Value("${base-directory}")
    private String baseDirectory;
    private final DocumentsEmployeeRepository documentsEmployeeRepository;

    public DocumentsEmployeeImpl(DocumentsEmployeeRepository documentsEmployeeRepository) {
        this.documentsEmployeeRepository = documentsEmployeeRepository;
    }

    /*@Override
    public DocumentsEmployee saveDocumentsEmployee(MultipartFile multipartFile, DocumentsEmployee documentsEmployee) {
        try {
            ConexionFTP conexionFTP = new ConexionFTP();
            if(conexionFTP.conectar()){
                conexionFTP.cambiarCarpeta("documentacionPersona");
                if (!conexionFTP.cambiarCarpeta(String.valueOf(documentsEmployee.getEmployee().getEmployeeId()))) {
                    if (conexionFTP.crearCarpeta(String.valueOf(documentsEmployee.getEmployee().getEmployeeId()))) {
                    }
                }
                documentsEmployee.setDocumentsEmployeeCreationDate(Timestamp.valueOf(LocalDateTime.now()));
                documentsEmployee.setDocumentsEmployeeEditDate(Timestamp.valueOf(LocalDateTime.now()));
                documentsEmployee.setDocumentsEmployeeUrl("documentacionPersona/"+documentsEmployee.getEmployee().getEmployeeId()+"_"+documentsEmployee.getTypeDocuments().getTypeDocumentId()+".pdf");
                documentsEmployee.setDocumentsEmployeeName(documentsEmployee.getEmployee().getEmployeeId()+"_"+documentsEmployee.getTypeDocuments().getTypeDocumentId()+".pdf");

                if (conexionFTP.enviarArchivo(documentsEmployee.getDocumentsEmployeeName(), multipartFile.getInputStream())) {
                    return documentsEmployeeRepository.save(documentsEmployee);
                }else {
                    System.out.println("Error");
                }
                conexionFTP.desconectar();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }finally {
            return null;
        }
    }*/
    @Override
    public DocumentsEmployee saveDocumentsEmployee(MultipartFile multipartFile, DocumentsEmployee documentsEmployee) {
        try {
            // Directorio base en el servidor
            String employeeFolder = String.valueOf(documentsEmployee.getEmployee().getEmployeeId());
            Path employeePath = Paths.get(this.baseDirectory, employeeFolder);

            // Crear el directorio si no existe
            if (!Files.exists(employeePath)) {
                Files.createDirectories(employeePath);
            }

            // Definir la ruta y el nombre del archivo
            String fileName = documentsEmployee.getEmployee().getEmployeeId() + "_" +
                    documentsEmployee.getTypeDocuments().getTypeDocumentId() + ".pdf";
            Path filePath = employeePath.resolve(fileName);

            // Guardar el archivo en el servidor
            Files.copy(multipartFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Actualizar información del objeto DocumentsEmployee
            documentsEmployee.setDocumentsEmployeeCreationDate(Timestamp.valueOf(LocalDateTime.now()));
            documentsEmployee.setDocumentsEmployeeEditDate(Timestamp.valueOf(LocalDateTime.now()));
            documentsEmployee.setDocumentsEmployeeUrl(employeePath.toString() + "\\" + fileName);
            documentsEmployee.setDocumentsEmployeeName(fileName);

            // Guardar en el repositorio
            return documentsEmployeeRepository.save(documentsEmployee);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null; // Retornar null en caso de error
        }
    }

    @Override
    public DocumentsEmployee updateDocumentsEmployee(DocumentsEmployee documentsEmployee) {
        DocumentsEmployee existingDocumentsEmployee = documentsEmployeeRepository.findById(documentsEmployee.getDocumentsEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("El documento del empleado no existe: " + documentsEmployee.getDocumentsEmployeeId()));
        documentsEmployee.setDocumentsEmployeeCreationDate(existingDocumentsEmployee.getDocumentsEmployeeCreationDate());
        documentsEmployee.setDocumentsEmployeeEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return documentsEmployeeRepository.save(documentsEmployee);
    }

    @Override
    public Boolean deleteDocumentsEmployee(Integer documentsEmployeeId) {
        if (documentsEmployeeRepository.existsById(documentsEmployeeId)) {
            documentsEmployeeRepository.deleteById(documentsEmployeeId);
            return true;
        }
        return false;
    }

    @Override
    public List<DocumentsEmployee> listDocumentsEmployees() {
        return documentsEmployeeRepository.findAll();
    }

    @Override
    public List<DocumentsEmployee> getDocumentsEmployee(Integer employeeId) {
        return documentsEmployeeRepository.findByEmployeeEmployeeId(employeeId);
    }

    @Override
    public List<TypeDocuments> getDocumentsEmployeeLoaded(Integer employeeId) {
        return documentsEmployeeRepository.getDocumentEmployeeLoaded(employeeId);
    }

    @Override
    public Resource downloadDocument(Integer documentsEmployeeId) {
        DocumentsEmployee documentsEmployee = documentsEmployeeRepository.findById(documentsEmployeeId)
                .orElseThrow(() -> new IllegalArgumentException("El documento del empleado no existe: " + documentsEmployeeId));
        try {
            Path employeePath = Paths.get(documentsEmployee.getDocumentsEmployeeUrl());
            if (Files.exists(employeePath)) {
                Resource resource = new UrlResource(employeePath.toUri());

                if (resource.exists() && resource.isReadable()) {
                    return resource;
                } else {
                    throw new IOException("El archivo no es legible.");
                }
            } else {
                throw new FileNotFoundException("El archivo no existe en la ruta especificada.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al intentar descargar el documento: " + e.getMessage());
        }
    }

    @Override
    public List<Map<String, Object>> getReportDocuments() {
        Functions newFunction = new Functions();
        return newFunction.bodyOrganizerGetReportDocuments(documentsEmployeeRepository.getReportDocuments());
    }

    @Override
    public List<Map<String, Object>> getReportDocumentsEmployee() {
        Functions newFunction = new Functions();
        return newFunction.bodyOrganizerGetReportDocumentsEmployee(documentsEmployeeRepository.getReportDocumentsEmployee());
    }

}

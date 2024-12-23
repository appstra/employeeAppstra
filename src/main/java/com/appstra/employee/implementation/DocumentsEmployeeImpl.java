package com.appstra.employee.implementation;

import com.appstra.employee.entity.DocumentsEmployee;
import com.appstra.employee.methods.ConexionFTP;
import com.appstra.employee.repository.DocumentsEmployeeRepository;
import com.appstra.employee.service.DocumentsEmployeeService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DocumentsEmployeeImpl implements DocumentsEmployeeService {
    private final DocumentsEmployeeRepository documentsEmployeeRepository;

    public DocumentsEmployeeImpl(DocumentsEmployeeRepository documentsEmployeeRepository) {
        this.documentsEmployeeRepository = documentsEmployeeRepository;
    }

    @Override
    public DocumentsEmployee saveDocumentsEmployee(DocumentsEmployee documentsEmployee) {
        documentsEmployee.setDocumentsEmployeeCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        documentsEmployee.setDocumentsEmployeeEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return documentsEmployeeRepository.save(documentsEmployee);
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
    public DocumentsEmployee getDocumentsEmployee(Integer documentsEmployeeId) {
        return documentsEmployeeRepository.findById(documentsEmployeeId)
                .orElseThrow(() -> new NoSuchElementException("El documento del empleado con el ID: " + documentsEmployeeId + " no se encontró"));
    }
}

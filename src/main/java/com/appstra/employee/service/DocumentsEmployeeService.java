package com.appstra.employee.service;

import com.appstra.employee.entity.DocumentsEmployee;

import java.util.List;

public interface DocumentsEmployeeService {
    DocumentsEmployee saveDocumentsEmployee(DocumentsEmployee documentsEmployee);
    DocumentsEmployee updateDocumentsEmployee(DocumentsEmployee documentsEmployee);
    Boolean deleteDocumentsEmployee(Integer documentsEmployeeId);
    List<DocumentsEmployee> listDocumentsEmployees();
    DocumentsEmployee getDocumentsEmployee(Integer documentsEmployeeId);
}

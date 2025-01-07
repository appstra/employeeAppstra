package com.appstra.employee.service;

import com.appstra.employee.entity.DocumentsEmployee;
import com.appstra.employee.entity.TypeDocuments;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentsEmployeeService {
    DocumentsEmployee saveDocumentsEmployee(MultipartFile multipartFile, DocumentsEmployee documentsEmployee);
    DocumentsEmployee updateDocumentsEmployee(DocumentsEmployee documentsEmployee);
    Boolean deleteDocumentsEmployee(Integer documentsEmployeeId);
    List<DocumentsEmployee> listDocumentsEmployees();
    List<DocumentsEmployee>  getDocumentsEmployee(Integer employeeId);
    List<TypeDocuments> getDocumentsEmployeeLoaded (Integer employeeId);
}

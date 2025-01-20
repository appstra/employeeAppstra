package com.appstra.employee.service;

import com.appstra.employee.entity.DocumentsEmployee;
import com.appstra.employee.entity.TypeDocuments;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface DocumentsEmployeeService {
    DocumentsEmployee saveDocumentsEmployee(MultipartFile multipartFile, DocumentsEmployee documentsEmployee);
    DocumentsEmployee updateDocumentsEmployee(DocumentsEmployee documentsEmployee);
    Boolean deleteDocumentsEmployee(Integer documentsEmployeeId);
    List<DocumentsEmployee> listDocumentsEmployees();
    List<DocumentsEmployee>  getDocumentsEmployee(Integer employeeId);
    List<TypeDocuments> getDocumentsEmployeeLoaded (Integer employeeId);
    Resource downloadDocument(Integer documentsEmployeeId);
    List<Map<String, Object>> getReportDocuments();
    List<Map<String, Object>> getReportDocumentsEmployee();
}

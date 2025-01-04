package com.appstra.employee.service;

import com.appstra.employee.entity.TypeDocuments;

import java.util.List;

public interface TypeDocumentsService {
    TypeDocuments saveTypeDocuments(TypeDocuments typeDocuments);
    TypeDocuments updateTypeDocuments(TypeDocuments typeDocuments);
    Boolean deleteTypeDocuments(Integer typeDocumentId);
    List<TypeDocuments> listTypeDocuments();
    TypeDocuments getTypeDocuments(Integer typeDocumentId);
}

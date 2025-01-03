package com.appstra.employee.service;

import com.appstra.employee.entity.DocumentGroup;

import java.util.List;

public interface DocumentGroupService {
    DocumentGroup saveDocumentGroup(DocumentGroup documentGroup);
    DocumentGroup updateDocumentGroup(DocumentGroup documentGroup);
    Boolean deleteDocumentGroup(Integer documentGroupId);
    List<DocumentGroup> listDocumentGroups();
    DocumentGroup getDocumentGroup(Integer documentGroupId);
}


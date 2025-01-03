package com.appstra.employee.implementation;

import com.appstra.employee.entity.DocumentGroup;
import com.appstra.employee.repository.DocumentGroupRepository;
import com.appstra.employee.service.DocumentGroupService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DocumentGroupImpl implements DocumentGroupService {
    private final DocumentGroupRepository documentGroupRepository;

    public DocumentGroupImpl(DocumentGroupRepository documentGroupRepository) {
        this.documentGroupRepository = documentGroupRepository;
    }

    @Override
    public DocumentGroup saveDocumentGroup(DocumentGroup documentGroup) {
        documentGroup.setDocumentGroupCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        documentGroup.setDocumentGroupEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return documentGroupRepository.save(documentGroup);
    }

    @Override
    public DocumentGroup updateDocumentGroup(DocumentGroup documentGroup) {
        DocumentGroup existingDocumentGroup = documentGroupRepository.findById(documentGroup.getDocumentGroupId())
                .orElseThrow(() -> new IllegalArgumentException("El grupo de documentos no existe: " + documentGroup.getDocumentGroupId()));
        documentGroup.setDocumentGroupCreationDate(existingDocumentGroup.getDocumentGroupCreationDate());
        documentGroup.setDocumentGroupEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return documentGroupRepository.save(documentGroup);
    }

    @Override
    public Boolean deleteDocumentGroup(Integer documentGroupId) {
        if (documentGroupRepository.existsById(documentGroupId)) {
            documentGroupRepository.deleteById(documentGroupId);
            return true;
        }
        return false;
    }

    @Override
    public List<DocumentGroup> listDocumentGroups() {
        return documentGroupRepository.findAll();
    }

    @Override
    public DocumentGroup getDocumentGroup(Integer documentGroupId) {
        return documentGroupRepository.findById(documentGroupId)
                .orElseThrow(() -> new NoSuchElementException("El grupo de documentos con el ID: " + documentGroupId + " no se encontró"));
    }
}


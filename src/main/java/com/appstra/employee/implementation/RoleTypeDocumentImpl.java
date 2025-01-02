package com.appstra.employee.implementation;

import com.appstra.employee.entity.RoleTypeDocument;
import com.appstra.employee.repository.RoleTypeDocumentRepository;
import com.appstra.employee.service.RoleTypeDocumentService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoleTypeDocumentImpl implements RoleTypeDocumentService {
    private final RoleTypeDocumentRepository roleTypeDocumentRepository;

    public RoleTypeDocumentImpl(RoleTypeDocumentRepository roleTypeDocumentRepository) {
        this.roleTypeDocumentRepository = roleTypeDocumentRepository;
    }

    @Override
    public RoleTypeDocument saveRoleTypeDocument(RoleTypeDocument roleTypeDocument) {
        roleTypeDocument.setRoleTypeDocumentCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        roleTypeDocument.setRoleTypeDocumentEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return roleTypeDocumentRepository.save(roleTypeDocument);
    }

    @Override
    public RoleTypeDocument updateRoleTypeDocument(RoleTypeDocument roleTypeDocument) {
        RoleTypeDocument existingRoleTypeDocument = roleTypeDocumentRepository.findById(roleTypeDocument.getRoleTypeDocumentId())
                .orElseThrow(() -> new IllegalArgumentException("El documento de tipo rol no existe: " + roleTypeDocument.getRoleTypeDocumentId()));
        roleTypeDocument.setRoleTypeDocumentCreationDate(existingRoleTypeDocument.getRoleTypeDocumentCreationDate());
        roleTypeDocument.setRoleTypeDocumentEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return roleTypeDocumentRepository.save(roleTypeDocument);
    }

    @Override
    public Boolean deleteRoleTypeDocument(Integer id) {
        if (roleTypeDocumentRepository.existsById(id)) {
            roleTypeDocumentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<RoleTypeDocument> listRoleTypeDocuments() {
        return roleTypeDocumentRepository.findAll();
    }
}


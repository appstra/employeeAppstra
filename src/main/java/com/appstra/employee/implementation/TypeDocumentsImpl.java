package com.appstra.employee.implementation;

import com.appstra.employee.entity.TypeDocuments;
import com.appstra.employee.repository.TypeDocumentsRepository;
import com.appstra.employee.service.TypeDocumentsService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TypeDocumentsImpl implements TypeDocumentsService {
    private final TypeDocumentsRepository typeDocumentsRepository;

    public TypeDocumentsImpl(TypeDocumentsRepository typeDocumentsRepository) {
        this.typeDocumentsRepository = typeDocumentsRepository;
    }

    @Override
    public TypeDocuments saveTypeDocuments(TypeDocuments typeDocuments) {
        typeDocuments.setTypeDocumentCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        typeDocuments.setTypeDocumentEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return typeDocumentsRepository.save(typeDocuments);
    }

    @Override
    public TypeDocuments updateTypeDocuments(TypeDocuments typeDocuments) {
        TypeDocuments existingTypeDocuments = typeDocumentsRepository.findById(typeDocuments.getTypeDocumentId())
                .orElseThrow(() -> new IllegalArgumentException("El tipo de documento no existe: " + typeDocuments.getTypeDocumentId()));
        typeDocuments.setTypeDocumentCreationDate(existingTypeDocuments.getTypeDocumentCreationDate());
        typeDocuments.setTypeDocumentEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return typeDocumentsRepository.save(typeDocuments);
    }

    @Override
    public Boolean deleteTypeDocuments(Integer tdocId) {
        if (typeDocumentsRepository.existsById(tdocId)) {
            typeDocumentsRepository.deleteById(tdocId);
            return true;
        }
        return false;
    }

    @Override
    public List<TypeDocuments> listTypeDocuments() {
        return typeDocumentsRepository.findAll();
    }

    @Override
    public TypeDocuments getTypeDocuments(Integer tdocId) {
        return typeDocumentsRepository.findById(tdocId)
                .orElseThrow(() -> new NoSuchElementException("El tipo de documento con el ID: " + tdocId + " no se encontró"));
    }

    @Override
    public List<TypeDocuments> listTypeDocumentsRoleId(Integer roleId) {
        return typeDocumentsRepository.findByRoleTypeDocumentListRoleId(roleId);
    }
}

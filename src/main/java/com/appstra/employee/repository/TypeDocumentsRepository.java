package com.appstra.employee.repository;

import com.appstra.employee.entity.TypeDocuments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeDocumentsRepository extends JpaRepository<TypeDocuments,Integer> {
    List<TypeDocuments> findByRoleTypeDocumentListRoleId(Integer roleId);
}

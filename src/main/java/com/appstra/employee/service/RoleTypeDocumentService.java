package com.appstra.employee.service;


import com.appstra.employee.entity.RoleTypeDocument;

import java.util.List;

public interface RoleTypeDocumentService {
    RoleTypeDocument saveRoleTypeDocument(RoleTypeDocument roleTypeDocument);
    RoleTypeDocument updateRoleTypeDocument(RoleTypeDocument roleTypeDocumentId);
    Boolean deleteRoleTypeDocument(Integer roleTypeDocumentId);
    List<RoleTypeDocument> listRoleTypeDocuments();
}

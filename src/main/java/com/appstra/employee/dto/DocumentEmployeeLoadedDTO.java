package com.appstra.employee.dto;

import com.appstra.employee.entity.TypeDocuments;

public class DocumentEmployeeLoadedDTO {
    private TypeDocuments typeDocuments;

    public DocumentEmployeeLoadedDTO(TypeDocuments typeDocuments) {
        this.typeDocuments = typeDocuments;
    }

    public TypeDocuments getTypeDocuments() {
        return typeDocuments;
    }

    public void setTypeDocuments(TypeDocuments typeDocuments) {
        this.typeDocuments = typeDocuments;
    }
}

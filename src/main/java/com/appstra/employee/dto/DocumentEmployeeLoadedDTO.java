package com.appstra.employee.dto;

import com.appstra.employee.entity.TypeDocuments;

public class DocumentEmployeeLoadedDTO {
    private TypeDocuments typeDocuments;
    private Boolean loaded;

    public DocumentEmployeeLoadedDTO(TypeDocuments typeDocuments, Boolean loaded) {
        this.typeDocuments = typeDocuments;
        this.loaded = loaded;
    }

    public TypeDocuments getTypeDocuments() {
        return typeDocuments;
    }

    public void setTypeDocuments(TypeDocuments typeDocuments) {
        this.typeDocuments = typeDocuments;
    }

    public Boolean getLoaded() {
        return loaded;
    }

    public void setLoaded(Boolean loaded) {
        this.loaded = loaded;
    }
}

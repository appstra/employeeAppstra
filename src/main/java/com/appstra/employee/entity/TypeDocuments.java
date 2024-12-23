package com.appstra.employee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TYPE_DOCUMENTS", schema = "PARAMETERIZATION")
public class TypeDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYDO_ID")
    @Comment("Identificador único del tipo de documento")
    private Integer typeDocumentId;

    @Column(name = "TYDO_NAME")
    @Comment("Nombre del tipo de documento")
    private String typeDocumentName;

    @Column(name = "STATE_ID")
    @Comment("ID del estado asociado al tipo de documento, base de datos de userAppstra")
    private Integer stateId;

    @Column(name = "TYDO_EDIT_DATE")
    @Comment("Fecha de última edición")
    private Timestamp typeDocumentEditDate;

    @Column(name = "TYDO_CREATION_DATE")
    @Comment("Fecha de creación del tipo de documento")
    private Timestamp typeDocumentCreationDate;

    @Column(name = "TYDO_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer typeDocumentEditUserId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "typeDocuments")
    private List<DocumentsEmployee> documentsEmployeeList;
}


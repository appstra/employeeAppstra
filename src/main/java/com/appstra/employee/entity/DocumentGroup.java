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
@Table(name = "DOCUMENT_GROUP", schema = "PARAMETERIZATION")
public class DocumentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOGR_ID")
    @Comment("Identificador único del grupo de documentos")
    private Integer documentGroupId;

    @Column(name = "DOGR_NAME")
    @Comment("Nombre del grupo de documentos")
    private String documentGroupName;

    @Column(name = "STATE_ID")
    @Comment("ID del estado asociado al grupo de documentos, base de datos de userAppstra")
    private Integer stateId;

    @Column(name = "DOGR_EDIT_DATE")
    @Comment("Fecha de última edición del grupo de documentos")
    private Timestamp documentGroupEditDate;

    @Column(name = "DOGR_CREATION_DATE")
    @Comment("Fecha de creación del grupo de documentos")
    private Timestamp documentGroupCreationDate;

    @Column(name = "DOGR_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer documentGroupEditUserId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "documentGroup")
    @Comment("Lista de documentos asociados al grupo de documentos")
    private List<TypeDocuments> typeDocumentsList;
}

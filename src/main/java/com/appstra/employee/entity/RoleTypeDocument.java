package com.appstra.employee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "ROLE_TYPE_DOCUMENT", schema = "TRANSACTIONAL")
public class RoleTypeDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RTDO_ID")
    @Comment("Identificador único del tipo documento por rol")
    private Integer roleTypeDocumentId;

    @Column(name = "ROLE_ID")
    @Comment("ID del rol que de la empresa, llave primaria de companyAppstra")
    private  Integer roleId;

    @ManyToOne
    @JoinColumn(name = "TYDO_ID", referencedColumnName = "TYDO_ID")
    private  TypeDocuments typeDocuments;

    @Column(name = "RTDO_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer RoleTypeDocumentEditUserId;

    @Column(name = "RTDO_EDIT_DATE")
    @Comment("Fecha de última edición")
    private Timestamp RoleTypeDocumentEditDate;

    @Column(name = "RTDO_CREATION_DATE")
    @Comment("Fecha de creación del documento del empleado")
    private Timestamp RoleTypeDocumentCreationDate;
}

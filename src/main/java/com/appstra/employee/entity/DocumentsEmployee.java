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
@Table(name = "DOCUMENTS_EMPLOYEE", schema = "TRANSACTIONAL")
public class DocumentsEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOEM_ID")
    @Comment("Identificador único del documento del empleado")
    private Integer documentsEmployeeId;

    @ManyToOne
    @JoinColumn(name = "TYDO_ID", referencedColumnName = "TYDO_ID")
    private  TypeDocuments typeDocuments;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "EMPL_ID", referencedColumnName = "EMPL_ID")
    private  Employee employee;

    @Column(name = "DOEM_URL")
    @Comment("Ubicacion del archivo en el FTP")
    private String documentsEmployeeUrl;

    @Column(name = "DOEM_NAME")
    @Comment("Nombre del archivo")
    private String documentsEmployeeName;

    @Column(name = "DOEM_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer documentsEmployeeEditUserId;

    @Column(name = "DOEM_EDIT_DATE")
    @Comment("Fecha de última edición")
    private Timestamp documentsEmployeeEditDate;

    @Column(name = "DOEM_CREATION_DATE")
    @Comment("Fecha de creación del documento del empleado")
    private Timestamp documentsEmployeeCreationDate;
}


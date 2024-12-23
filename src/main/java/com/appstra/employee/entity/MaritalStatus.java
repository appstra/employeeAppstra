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
@Table(name = "MARITAL_STATUS", schema = "TRANSACTIONAL")
public class MaritalStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAST_ID")
    @Comment("Identificador único del estado civil")
    private Integer maritalStatusId;

    @Column(name = "MAST_NAME")
    @Comment("Nombre del estado civil")
    private String maritalStatusName;

    @Column(name = "MAST_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer maritalStatusEditUserId;

    @Column(name = "MAST_EDIT_DATE")
    @Comment("Fecha de última edición")
    private Timestamp maritalStatusEditDate;

    @Column(name = "MAST_CREATION_DATE")
    @Comment("Fecha de creación del estado civil")
    private Timestamp maritalStatusCreationDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "maritalStatus")
    private List<Employee> EmployeeList;
}


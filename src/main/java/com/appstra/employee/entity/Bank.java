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
@Table(name = "BANK", schema = "PARAMETERIZATION")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BANK_ID")
    @Comment("Identificador único del banco")
    private Integer bankId;

    @Column(name = "BANK_NAME")
    @Comment("Nombre del banco")
    private String bankName;

    @Column(name = "STATE_ID")
    @Comment("ID del estado asociado al banco, base de datos de userAppstra")
    private Integer stateId;

    @Column(name = "BANK_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer bankEditUserId;

    @Column(name = "BANK_EDIT_DATE")
    @Comment("Fecha de última edición")
    private Timestamp bankEditDate;

    @Column(name = "BANK_CREATION_DATE")
    @Comment("Fecha de creación del banco")
    private Timestamp bankCreationDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "bank")
    private List<Employee> EmployeeList;
}


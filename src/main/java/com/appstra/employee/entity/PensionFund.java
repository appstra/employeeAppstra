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
@Table(name = "PENSION_FUND", schema = "PARAMETERIZATION")
public class PensionFund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PEFU_ID")
    @Comment("Identificador único del fondo de pensión")
    private Integer pensionFundId;

    @Column(name = "PEFU_NAME")
    @Comment("Nombre del fondo de pensión")
    private String pensionFundName;

    @Column(name = "PEFU_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer pensionFundEditUserId;

    @Column(name = "PEFU_EDIT_DATE")
    @Comment("Fecha de última edición")
    private Timestamp pensionFundEditDate;

    @Column(name = "PEFU_CREATION_DATE")
    @Comment("Fecha de creación del fondo de pensión")
    private Timestamp pensionFundCreationDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "pensionFund")
    private List<Employee> EmployeeList;
}


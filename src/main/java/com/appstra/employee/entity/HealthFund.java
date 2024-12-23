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
@Table(name = "HEALTH_FUND", schema = "PARAMETERIZATION")
public class HealthFund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HEFU_ID")
    @Comment("Identificador único del fondo de salud (EPS)")
    private Integer healthFundId;

    @Column(name = "HEFU_NAME")
    @Comment("Nombre del fondo de salud (EPS)")
    private String healthFundName;

    @Column(name = "HEFU_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer healthFundEditUserId;

    @Column(name = "HEFU_EDIT_DATE")
    @Comment("Fecha de última edición")
    private Timestamp healthFundEditDate;

    @Column(name = "HEFU_CREATION_DATE")
    @Comment("Fecha de creación del fondo de salud")
    private Timestamp healthFundCreationDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "healthFund")
    private List<Employee> EmployeeList;
}


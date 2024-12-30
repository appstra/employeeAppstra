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
@Table(name = "COMPENSATION_FUND", schema = "PARAMETERIZATION")
public class CompensationFund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COFU_ID")
    @Comment("Identificador único de las Caja de companzacion")
    private Integer compensationFundId;

    @Column(name = "COFU_NAME")
    @Comment("Nombre asociado a la Caja de companzacion")
    private String compensationFundName;

    @Column(name = "COFU_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer compensationFundEditUserId;

    @Column(name = "COFU_EDIT_DATE")
    @Comment("Fecha de última edición")
    private Timestamp compensationFundEditDate;

    @Column(name = "COFU_CREATION_DATE")
    @Comment("Fecha de creación")
    private Timestamp compensationFundCreationDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "compensationFund")
    private List<Employee> EmployeeList;
}

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
@Table(name = "CESANTIAS", schema = "PARAMETERIZATION")
public class Cesantias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CESA_ID")
    @Comment("Identificador único de las cesantías")
    private Integer cesantiasId;

    @Column(name = "CESA_NAME")
    @Comment("Nombre asociado a las cesantías")
    private String cesantiasName;

    @Column(name = "CESA_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer cesantiasEditUserId;

    @Column(name = "CESA_EDIT_DATE")
    @Comment("Fecha de última edición")
    private Timestamp cesantiasEditDate;

    @Column(name = "CESA_CREATION_DATE")
    @Comment("Fecha de creación")
    private Timestamp cesantiasCreationDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "cesantias")
    private List<Employee> EmployeeList;
}


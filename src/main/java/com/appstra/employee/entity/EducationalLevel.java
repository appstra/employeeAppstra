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
@Table(name = "EDUCATIONAL_LEVEL", schema = "PARAMETERIZATION")
public class EducationalLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EDLE_ID")
    @Comment("Identificador único del nivel educativo")
    private Integer educationalLevelId;

    @Column(name = "EDLE_NAME")
    @Comment("Nombre del nivel educativo")
    private String educationalLevelName;

    @Column(name = "EDLE_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer educationalLevelEditUserId;

    @Column(name = "EDLE_EDIT_DATE")
    @Comment("Fecha de última edición")
    private Timestamp educationalLevelEditDate;

    @Column(name = "EDLE_CREATION_DATE")
    @Comment("Fecha de creación del nivel educativo")
    private Timestamp educationalLevelCreationDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "educationalLevel")
    private List<Employee> EmployeeList;
}


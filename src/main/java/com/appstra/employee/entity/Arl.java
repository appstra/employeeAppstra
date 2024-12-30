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
@Table(name = "ARL", schema = "PARAMETERIZATION")
public class Arl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ARL_ID")
    @Comment("Identificador único de las ARL")
    private Integer arlId;

    @Column(name = "ARL_NAME")
    @Comment("Nombre asociado a las ARL")
    private String arlName;

    @Column(name = "ARL_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer arlEditUserId;

    @Column(name = "ARL_EDIT_DATE")
    @Comment("Fecha de última edición")
    private Timestamp arlEditDate;

    @Column(name = "ARL_CREATION_DATE")
    @Comment("Fecha de creación")
    private Timestamp arlCreationDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "arl")
    private List<Employee> EmployeeList;
}

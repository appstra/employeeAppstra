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
@Table(name = "DRIVING_PASS", schema = "TRANSACTIONAL")
public class DrivingPass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DRPA_ID")
    @Comment("Identificador único del Driving Pass")
    private Integer drivingPassId;

    @Column(name = "DRPA_TYPE")
    @Comment("Tipo del Driving Pass")
    private String drivingPassType;

    @Column(name = "DRPA_CATEGORY")
    @Comment("Categoría del Driving Pass")
    private String drivingPassCategory;

    @Column(name = "DRPA_NUMBER")
    @Comment("Número del Driving Pass")
    private String drivingPassNumber;

    @Column(name = "DRPA_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer drivingPassEditUserId;

    @Column(name = "DRPA_EDIT_DATE")
    @Comment("Fecha de la última edición")
    private Timestamp drivingPassEditDate;

    @Column(name = "DRPA_CREATION_DATE")
    @Comment("Fecha de creación del Driving Pass")
    private Timestamp drivingPassCreationDate;

    @ManyToOne
    @JoinColumn(name = "EMPL_ID", referencedColumnName = "EMPL_ID")
    private  Employee employee;
}

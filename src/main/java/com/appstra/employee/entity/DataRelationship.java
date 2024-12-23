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
@Table(name = "DATA_RELATIVESHIP", schema = "TRANSACTIONAL")
public class DataRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DARE_ID")
    @Comment("Identificador único de la relación de datos")
    private Integer dataRelationshipId;

    @ManyToOne
    @JoinColumn(name = "EMPL_ID", referencedColumnName = "EMPL_ID")
    private  Employee employee;

    @Column(name = "DARE_FIRST_NAME")
    @Comment("Primer nombre del familiar")
    private String dataRelationshipFirstName;

    @Column(name = "DARE_LAST_NAME")
    @Comment("Apellido del familiar")
    private String dataRelationshipLastName;

    @Column(name = "DCTY_ID")
    @Comment("ID del tipo de documento, base de datos de userAppstra")
    private Integer dctyId;

    @Column(name = "DARE_IDENTIFICATION_NUMBER")
    @Comment("Número de identificación del familiar")
    private String dataRelationshipIdentificationNumber;

    @Column(name = "DARE_BIRTHDAY_DATE")
    @Comment("Fecha de nacimiento del familiar")
    private Timestamp dataRelationshipBirthdayDate;

    @Column(name = "DARE_GENDER")
    @Comment("Género del familiar")
    private String dataRelationshipGender;

    @Column(name = "DARE_RELATIVESHIP")
    @Comment("Relación de parentesco con el empleado")
    private String dataRelationshipRelationship;

    @Column(name = "DARE_MOBILE_PHONE")
    @Comment("Teléfono móvil del familiar")
    private String dataRelationshipMobilePhone;

    @Column(name = "DARE_BENEFICIARY")
    @Comment("Indica si el familiar es beneficiario")
    private Boolean dataRelationshipBeneficiary;

    @Column(name = "DARE_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición")
    private Integer dataRelationshipEditUserId;

    @Column(name = "DARE_EDIT_DATE")
    @Comment("Fecha de la última edición")
    private Timestamp dataRelationshipEditDate;

    @Column(name = "DARE_CREATION_DATE")
    @Comment("Fecha de creación del registro")
    private Timestamp dataRelationshipCreationDate;
}


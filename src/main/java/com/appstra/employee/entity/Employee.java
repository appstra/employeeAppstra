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
@Table(name = "EMPLOYEE", schema = "PARAMETERIZATION")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPL_ID")
    @Comment("Identificador único del empleado")
    private Integer employeeId;

    @Column(name = "COMP_ID")
    @Comment("ID de la compañía asociada al empleado, base de datos de CompanyAppstra")
    private Integer companyId;

    @Column(name = "PERS_ID")
    @Comment("Campo de la base de datos de UserAppstra tabla personas")
    private Integer personId;

    @Column(name = "STATE_ID")
    @Comment("ID del estado asociado al empleado, base de datos de userAppstra")
    private Integer stateId;

    @ManyToOne
    @JoinColumn(name = "BANK_ID", referencedColumnName = "BANK_ID")
    private Bank bank;

    @Column(name = "EMPL_NUMBER_BANK")
    @Comment("Número de cuenta bancaria del empleado")
    private String employeeBankAccountNumber;

    @ManyToOne
    @JoinColumn(name = "MAST_ID", referencedColumnName = "MAST_ID")
    private  MaritalStatus maritalStatus;

    @Column(name = "ROLE_ID")
    @Comment("ID del rol asociado al empleado, base de datos de compañia")
    private Integer roleId;

    @ManyToOne
    @JoinColumn(name = "EDLE_ID", referencedColumnName = "EDLE_ID")
    private  EducationalLevel educationalLevel;

    @Column(name = "EMPL_PROFECION")
    @Comment("Profesión del empleado")
    private String employeeProfession;

    @ManyToOne
    @JoinColumn(name = "HEFU_ID", referencedColumnName = "HEFU_ID")
    private  HealthFund healthFund;

    @ManyToOne
    @JoinColumn(name = "PEFU_ID", referencedColumnName = "PEFU_ID")
    private  PensionFund pensionFund;

    @ManyToOne
    @JoinColumn(name = "CESA_ID", referencedColumnName = "CESA_ID")
    private  Cesantias cesantias;

    @ManyToOne
    @JoinColumn(name = "ARL_ID", referencedColumnName = "ARL_ID")
    private  Arl arl;

    @ManyToOne
    @JoinColumn(name = "COFU_ID", referencedColumnName = "COFU_ID")
    private  CompensationFund compensationFund;

    @Column(name = "EMPL_BUSINESS_MAIL")
    @Comment("Correo electrónico empresarial del empleado")
    private String employeeBusinessMail;

    @Column(name = "EMPL_CREATION_DATE")
    @Comment("Fecha de creación del empleado")
    private Timestamp employeeCreationDate;

    @Column(name = "EMPL_EDIT_DATE")
    @Comment("Fecha de última edición del empleado")
    private Timestamp employeeEditDate;

    @Column(name = "EMPL_EDIT_USER_ID")
    @Comment("ID del usuario que realizó la última edición del empleado")
    private Integer employeeEditUserId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "employee")
    private List<DocumentsEmployee> documentsEmployeeList;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "employee")
    private List<DrivingPass> drivingPassList;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "employee")
    private List<DataRelationship> dataRelationshipList;
}

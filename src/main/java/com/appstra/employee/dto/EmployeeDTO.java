package com.appstra.employee.dto;

public class EmployeeDTO {
    private Integer employeeId;
    private Integer companyId;
    private Integer personId;
    private Integer employeeRoleId;

    public EmployeeDTO(Integer employeeId, Integer companyId, Integer personId, Integer employeeRoleId) {
        this.employeeId = employeeId;
        this.companyId = companyId;
        this.personId = personId;
        this.employeeRoleId = employeeRoleId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getEmployeeRoleId() {
        return employeeRoleId;
    }

    public void setEmployeeRoleId(Integer employeeRoleId) {
        this.employeeRoleId = employeeRoleId;
    }
}

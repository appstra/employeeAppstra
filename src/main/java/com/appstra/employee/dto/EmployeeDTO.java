package com.appstra.employee.dto;

public class EmployeeDTO {
    private Integer employeeId;
    private Integer companyId;
    private Integer personId;
    private Integer roleId;

    public EmployeeDTO(Integer employeeId, Integer companyId, Integer personId, Integer roleId) {
        this.employeeId = employeeId;
        this.companyId = companyId;
        this.personId = personId;
        this.roleId = roleId;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}

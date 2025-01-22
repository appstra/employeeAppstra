package com.appstra.employee.service;

import com.appstra.employee.dto.EmployeeDTO;
import com.appstra.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Boolean deleteEmployee(Integer employeeId);
    List<Employee> listEmployees();
    Employee getEmployee(Integer employeeId);
    List<EmployeeDTO> getListPersonCompany(Integer personId);
    List<Employee>findByStateId (Integer stateId);
    List<Employee> listEmployeeCompany(Integer companyId);
}


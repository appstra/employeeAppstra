package com.appstra.employee.implementation;

import com.appstra.employee.dto.EmployeeDTO;
import com.appstra.employee.entity.Employee;
import com.appstra.employee.repository.EmployeeRepository;
import com.appstra.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setEmployeeCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        employee.setEmployeeEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("El empleado no existe: " + employee.getEmployeeId()));
        employee.setEmployeeCreationDate(existingEmployee.getEmployeeCreationDate());
        employee.setEmployeeEditDate(Timestamp.valueOf(LocalDateTime.now()));
        return employeeRepository.save(employee);
    }

    @Override
    public Boolean deleteEmployee(Integer employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new IllegalArgumentException("El empleado no existe: " + employeeId));
            employee.setStateId(12);
            employee.setEmployeeEditDate(Timestamp.valueOf(LocalDateTime.now()));
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> listEmployees() {
        return employeeRepository.findByStateIdNot(12);
    }

    @Override
    public Employee getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("El empleado con el ID: " + employeeId + " no se encontró"));
    }

    @Override
    public List<EmployeeDTO> getListPersonCompany(Integer personId) {
        return employeeRepository.findByPersonId(personId);
    }

    @Override
    public List<Employee> findByStateId(Integer stateId) {
        return employeeRepository.findByStateId(stateId);
    }
}

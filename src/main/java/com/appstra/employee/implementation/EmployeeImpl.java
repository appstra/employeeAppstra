package com.appstra.employee.implementation;

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
            employeeRepository.deleteById(employeeId);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> listEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("El empleado con el ID: " + employeeId + " no se encontró"));
    }
}

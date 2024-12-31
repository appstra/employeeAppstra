package com.appstra.employee.repository;

import com.appstra.employee.entity.DocumentsEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentsEmployeeRepository extends JpaRepository<DocumentsEmployee,Integer> {
    List<DocumentsEmployee> findByEmployeeEmployeeId (Integer employeeId);
}

package com.appstra.employee.repository;

import com.appstra.employee.dto.EmployeeDTO;
import com.appstra.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query("""
            SELECT
                new com.appstra.employee.dto.EmployeeDTO(e.employeeId, e.companyId, e.personId, e.roleId)
            FROM
                Employee e
            WHERE e.personId = :personId
            """)
    List<EmployeeDTO> findByPersonId(Integer personId);
}

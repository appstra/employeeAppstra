package com.appstra.employee.repository;

import com.appstra.employee.dto.DocumentEmployeeLoadedDTO;
import com.appstra.employee.entity.DocumentsEmployee;
import com.appstra.employee.entity.TypeDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentsEmployeeRepository extends JpaRepository<DocumentsEmployee,Integer> {

    List<DocumentsEmployee> findByEmployeeEmployeeId (Integer employeeId);
    @Query("""
        SELECT new com.appstra.employee.dto.DocumentEmployeeLoadedDTO(
            tydo
        )
        FROM Employee empl
        JOIN RoleTypeDocument rtdo ON empl.roleId = rtdo.roleId
        JOIN rtdo.typeDocuments tydo
        LEFT JOIN empl.documentsEmployeeList doem
            ON doem.typeDocuments.typeDocumentId = tydo.typeDocumentId
        WHERE empl.employeeId = :employeeId AND doem.documentsEmployeeId IS NULL
    """)
    List<DocumentEmployeeLoadedDTO> getDocumentEmployeeLoaded(Integer employeeId);

}

package com.appstra.employee.repository;

import com.appstra.employee.entity.DocumentsEmployee;
import com.appstra.employee.entity.TypeDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface DocumentsEmployeeRepository extends JpaRepository<DocumentsEmployee,Integer> {

    List<DocumentsEmployee> findByEmployeeEmployeeId (Integer employeeId);

    @Query("""
        SELECT new com.appstra.employee.entity.TypeDocuments(
            tydo.typeDocumentId,
            tydo.typeDocumentName,
            tydo.stateId,
            tydo.typeDocumentRequired,
            tydo.typeDocumentEditDate,
            tydo.typeDocumentCreationDate,
            tydo.typeDocumentEditUserId,
            dogr
        )
        FROM Employee empl
        JOIN RoleTypeDocument rtdo ON empl.roleId = rtdo.roleId
        JOIN rtdo.typeDocuments tydo
        JOIN tydo.documentGroup dogr
        LEFT JOIN empl.documentsEmployeeList doem
            ON doem.typeDocuments.typeDocumentId = tydo.typeDocumentId
        WHERE empl.employeeId = :employeeId AND doem.documentsEmployeeId IS NULL
    """)
    List<TypeDocuments> getDocumentEmployeeLoaded(Integer employeeId);

    @Query(value = """
        SELECT * FROM get_reportDocuments()
    """, nativeQuery = true)
    List<Map<String, Object>> getReportDocuments();

    @Query(value = """
        SELECT * FROM get_employee_documents()
    """, nativeQuery = true)
    List<Map<String, Object>> getReportDocumentsEmployee();


}

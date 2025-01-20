package com.appstra.employee.controller;

import com.appstra.employee.dto.EmployeeDTO;
import com.appstra.employee.entity.Employee;
import com.appstra.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/saveemployee")
    @Operation(summary = "Guardar Empleado", description = "Guardar un nuevo empleado")
    public ResponseEntity<Employee> saveEmployee(@Validated @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @PutMapping("/updateemployee")
    @Operation(summary = "Actualizar Empleado", description = "Actualizar la información de un empleado existente")
    public ResponseEntity<Employee> updateEmployee(@Validated @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }

    @PutMapping("/deleteemployee/{employeeId}")
    @Operation(summary = "Eliminar Empleado", description = "Eliminar un empleado por ID")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        return ResponseEntity.ok(employeeService.deleteEmployee(employeeId));
    }

    @GetMapping("/listemployee")
    @Operation(summary = "Lista de Empleados", description = "Obtener la lista de todos los empleados")
    public ResponseEntity<List<Employee>> listEmployee() {
        return ResponseEntity.ok(employeeService.listEmployees());
    }

    @GetMapping("/{employeeId}")
    @Operation(summary = "Información del Empleado", description = "Obtener información de un empleado por ID")
    public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") Integer employeeId) {
        return ResponseEntity.ok(employeeService.getEmployee(employeeId));
    }

    /**
     * EndPoint que se consume desde UserAppstra
     * @param personId
     * @return EmployeeDTO
     */
    @GetMapping("listPersonCompany/{personId}")
    @Operation(summary = "Listar empresas de la persona", description = "Listar empresas del empleado")
    public ResponseEntity<List<EmployeeDTO>> listPersonCompany(@PathVariable("personId") Integer personId) {
        return ResponseEntity.ok(employeeService.getListPersonCompany(personId));
    }

    @GetMapping("/listemployee/findByStateId/{stateId}")
    @Operation(summary = "Lista de Aspirantes por estado", description = "Obtener lista de todos los aspirantes por estado")
    public ResponseEntity<List<Employee>> findByStateId(@PathVariable("stateId") Integer stateId){
        return ResponseEntity.ok(employeeService.findByStateId(stateId));
    }


}

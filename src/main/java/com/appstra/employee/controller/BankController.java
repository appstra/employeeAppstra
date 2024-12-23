package com.appstra.employee.controller;

import com.appstra.employee.entity.Bank;
import com.appstra.employee.service.BankService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Bank")
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/savebank")
    @Operation(summary = "Guardar Banco", description = "Guardar nueva información de banco")
    public ResponseEntity<Bank> saveBank(@Validated @RequestBody Bank bank) {
        return ResponseEntity.ok(bankService.saveBank(bank));
    }

    @PutMapping("/updatebank")
    @Operation(summary = "Actualizar Banco", description = "Actualizar información de un banco existente")
    public ResponseEntity<Bank> updateBank(@Validated @RequestBody Bank bank) {
        return ResponseEntity.ok(bankService.updateBank(bank));
    }

    @DeleteMapping("/deletebank/{bankId}")
    @Operation(summary = "Eliminar Banco", description = "Eliminar un banco por ID")
    public ResponseEntity<Boolean> deleteBank(@PathVariable("bankId") Integer bankId) {
        return ResponseEntity.ok(bankService.deleteBank(bankId));
    }

    @GetMapping("/listbanks")
    @Operation(summary = "Lista de Bancos", description = "Obtener lista de todos los bancos")
    public ResponseEntity<List<Bank>> listBanks() {
        return ResponseEntity.ok(bankService.listBanks());
    }

    @GetMapping("/{bankId}")
    @Operation(summary = "Información del Banco", description = "Obtener información de un banco por ID")
    public ResponseEntity<Bank> getBank(@PathVariable("bankId") Integer bankId) {
        return ResponseEntity.ok(bankService.getBank(bankId));
    }
}

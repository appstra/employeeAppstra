package com.appstra.employee.repository;

import com.appstra.employee.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Integer> {

}

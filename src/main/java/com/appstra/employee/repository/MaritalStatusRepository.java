package com.appstra.employee.repository;

import com.appstra.employee.entity.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaritalStatusRepository extends JpaRepository<MaritalStatus,Integer> {
}

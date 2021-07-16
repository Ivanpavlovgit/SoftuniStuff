package com.example.dtodemo.repository;

import com.example.dtodemo.model.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

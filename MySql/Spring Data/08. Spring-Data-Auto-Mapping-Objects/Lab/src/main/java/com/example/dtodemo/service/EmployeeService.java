package com.example.dtodemo.service;

import com.example.dtodemo.model.dto.EmployeeCreateRequest;
import com.example.dtodemo.model.dto.EmployeeCreateResponse;
import com.example.dtodemo.model.dto.EmployeeDto;
import com.example.dtodemo.model.dto.ManagerDto;

import java.util.List;

public interface EmployeeService {
    ManagerDto findOne (Long id);
    List<ManagerDto> findAll();
    EmployeeCreateResponse save(EmployeeCreateRequest employeeCreateRequest);
}

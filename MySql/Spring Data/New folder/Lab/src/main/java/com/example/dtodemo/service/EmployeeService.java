package com.example.dtodemo.service;

import com.example.dtodemo.model.dto.ManagerDto;

import java.util.List;

public interface EmployeeService {
    ManagerDto findOne (Long id);
    List<ManagerDto> findAll();
}

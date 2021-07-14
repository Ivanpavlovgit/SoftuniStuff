package com.example.dtodemo.service;

import com.example.dtodemo.model.dto.ManagerDto;
import com.example.dtodemo.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeServiceImpl (EmployeeRepository employeeRepository,ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public ManagerDto findOne (Long id) {


        var employee = this.employeeRepository
                .findById (id)
                .orElseThrow ();
        return mapper.map (employee,ManagerDto.class);
  /*      new EmployeeDto ()
                .setFirstName (employee.getFirstName ())
                .setLastName (employee.getLastName ())
                .setSalary (employee.getIncome ());*/
    }

    @Override
    public List<ManagerDto> findAll () {

        return mapper.map (
                this.employeeRepository.findAll (),
                new TypeToken<List<ManagerDto>> () {
                }.getType ());

    }
}

package com.example.dtodemo;

import com.example.dtodemo.model.dto.ManagerDto;
import com.example.dtodemo.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {
    private final EmployeeService employeeService;

    public Main (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run (String... args) throws Exception {
        //   ManagerDto dto1 = this.employeeService.findOne (1L);
        var managers = this.employeeService.findAll ();
        managers.forEach (managerDto -> {
            System.out.println (managerDto.getFirstName ());
            managerDto.getSubordinates ().forEach (employeeDto -> {
                System.out.println ("\t" + employeeDto.getFirstName () + " " + employeeDto.getLastName () + " " + employeeDto.getIncome ());
            });
        });

    }
}

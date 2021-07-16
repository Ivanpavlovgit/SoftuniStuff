package com.example.dtodemo;

import com.example.dtodemo.model.dto.EmployeeCreateRequest;
import com.example.dtodemo.model.dto.EmployeeCreateResponse;
import com.example.dtodemo.service.EmployeeService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;

@Component
public class Main implements CommandLineRunner {
    private final EmployeeService employeeService;
    private final Gson gson;
    private final BufferedReader reader;

    public Main (EmployeeService employeeService,Gson gson,BufferedReader reader) {
        this.employeeService = employeeService;
        this.gson = gson;
        this.reader = reader;
    }

    @Override
    public void run (String... args) throws Exception {
        var line = reader.readLine ();
        while (!line.equals ("end")) {
            var cmdParts = line.split ("\\s+");
            switch (cmdParts[0]) {
                case "find" -> {
                    var    id             = Long.parseLong (cmdParts[1]);
                    var    managerDtoById = this.employeeService.findOne (id);
                    String result         = this.gson.toJson (managerDtoById);
                    System.out.println (result);
                }
                case "findAll" -> {
                    var allMangers = this.employeeService.findAll ();
                    System.out.println (this.gson.toJson (allMangers));
                }
                case "save" -> {
                    var manger   = cmdParts[1];
                    var request  = this.gson.fromJson (manger,EmployeeCreateRequest.class);
                    var response = this.employeeService.save (request);
                    System.out.println (this.gson.toJson (response));
                }
                case "save-from-file" -> {
                    FileReader fileReader = new FileReader ("src/main/resources/first-employee.json");

                    var request = this.gson
                            .fromJson (fileReader
                                    ,EmployeeCreateRequest.class);
                    var response = this.employeeService.save (request);
                    System.out.println (this.gson.toJson (response));
                }
                case "writeAllTo" -> {

                    FileWriter writer = new FileWriter ("src/main/resources/output.txt");
                    this.gson.toJson (this.employeeService.findAll (),writer);
                    writer.flush ();
                    writer.close ();
                }
            }
            line = reader.readLine ();
        }

    }

      /*  var managers = this.employeeService.findAll ();
        managers.forEach (managerDto -> {
            System.out.println (managerDto.getFirstName ());
            managerDto.getSubordinates ().forEach (employeeDto -> {
                System.out.println ("\t" + employeeDto.getFirstName () + " " + employeeDto.getLastName () + " " + employeeDto.getIncome ());
            });
        });*/

}


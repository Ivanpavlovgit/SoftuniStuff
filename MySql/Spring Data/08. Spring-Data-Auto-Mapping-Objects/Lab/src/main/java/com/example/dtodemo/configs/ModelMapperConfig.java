package com.example.dtodemo.configs;

import com.example.dtodemo.model.Entity.Employee;
import com.example.dtodemo.model.dto.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper mapper () {
        ModelMapper mapper = new ModelMapper ();
        mapper.addMappings (new PropertyMap<Employee, EmployeeDto> () {

            @Override
            protected void configure () {
                map ().setIncome (source.getSalary ());
            }
        });
        return mapper;
    }
}

package com.example.objectmapping.models.dto;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class ManagerDto extends BasicEmployeeDto {

    @Expose
    private List<EmployeeDto> subordinates;

    public List<EmployeeDto> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<EmployeeDto> subordinates) {
        this.subordinates = subordinates;
    }
}

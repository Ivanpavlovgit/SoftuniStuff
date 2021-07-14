package com.example.dtodemo.model.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Date birthDay;
    private String address;
    private Boolean isOnHoliday;
    private Employee manager;
    private Set<Employee> subordinates;

    public Boolean getOnHoliday () {
        return this.isOnHoliday;
    }

    public Employee setOnHoliday (Boolean onHoliday) {
        isOnHoliday = onHoliday;
        return this;
    }

    @ManyToOne
    public Employee getManager () {
        return this.manager;
    }

    public Employee setManager (Employee manager) {
        this.manager = manager;
        return this;
    }

    @OneToMany(mappedBy = "manager",fetch = FetchType.EAGER)
    public Set<Employee> getSubordinates () {
        return this.subordinates;
    }

    public Employee setSubordinates (Set<Employee> subordinates) {
        this.subordinates = subordinates;
        return this;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId () {
        return this.id;
    }

    public Employee setId (Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName () {
        return this.firstName;
    }

    public Employee setFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName () {
        return this.lastName;
    }

    public Employee setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BigDecimal getSalary () {
        return this.salary;
    }

    public Employee setSalary (BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public Date getBirthDay () {
        return this.birthDay;
    }

    public Employee setBirthDay (Date birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public String getAddress () {
        return this.address;
    }

    public Employee setAddress (String address) {
        this.address = address;
        return this;
    }

    public Employee () {
    }
}

package com.example.exc_xml.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedDto {

    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlAttribute(name = "age")
    private Integer age;

    public String getFirstName () {
        return this.firstName;
    }

    public UserSeedDto setFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName () {
        return this.lastName;
    }

    public UserSeedDto setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge () {
        return this.age;
    }

    public UserSeedDto setAge (Integer age) {
        this.age = age;
        return this;
    }

    public UserSeedDto () {
    }
}

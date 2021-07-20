package com.example.exc_xml.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedRootDto {
    @XmlElement(name="user")
  private  List<UserSeedDto> users;

    public List<UserSeedDto> getUsers () {
        return this.users;
    }

    public UserSeedRootDto setUsers (List<UserSeedDto> users) {
        this.users = users;
        return this;
    }

    public UserSeedRootDto () {
    }
}

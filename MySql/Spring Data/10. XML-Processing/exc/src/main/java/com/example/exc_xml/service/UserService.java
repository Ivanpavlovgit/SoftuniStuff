package com.example.exc_xml.service;

import com.example.exc_xml.model.dto.UserSeedDto;
import com.example.exc_xml.model.enitity.User;

import java.util.List;

public interface UserService {

    long getCount ();

    void seedUsers (List<UserSeedDto> users);

    User getRandomUser ();

}

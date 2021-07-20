package com.example.exc_xml.service;

import com.example.exc_xml.model.dto.ProductSeedDto;
import com.example.exc_xml.model.dto.UserSeedDto;

import java.util.List;

public interface UserService {

    long getCount ();

    void seedUsers (List<UserSeedDto> users);

}

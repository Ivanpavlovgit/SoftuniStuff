package com.example.json_exc.service;

import com.example.json_exc.model.Dto.UserSoldDto;
import com.example.json_exc.model.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void seedUsers () throws IOException;
    User findRandomUser();

    List<UserSoldDto> findAllUsersWithMoreThanOneSoldProduct ();
}

package com.example.json_exc.service;

import com.example.json_exc.model.entity.User;

import java.io.IOException;

public interface UserService {
    void seedUsers () throws IOException;
    User findRandomUser();
}

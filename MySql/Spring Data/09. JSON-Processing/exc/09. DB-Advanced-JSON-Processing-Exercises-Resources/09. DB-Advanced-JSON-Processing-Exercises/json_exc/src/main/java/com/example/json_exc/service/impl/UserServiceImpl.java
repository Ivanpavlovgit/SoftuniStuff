package com.example.json_exc.service.impl;

import com.example.json_exc.consts.GlobalConstants;
import com.example.json_exc.model.Dto.UserSeedDto;
import com.example.json_exc.model.entity.User;
import com.example.json_exc.repository.UserRepository;
import com.example.json_exc.service.UserService;
import com.example.json_exc.utilities.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    public static final String USERS_FILE_NAME = "users.json";

    public UserServiceImpl (UserRepository userRepository,ModelMapper modelMapper,ValidationUtil validationUtil,Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedUsers () throws IOException {
        if (this.userRepository.count () == 0) {
            Arrays.stream (gson
                    .fromJson (Files
                                    .readString (Path.of
                                            (GlobalConstants.FIRST_TASK_FOLDER_PATH + USERS_FILE_NAME)),
                            UserSeedDto[].class))
                    .filter (this.validationUtil::isValid)
                    .map (userSeedDto -> this.modelMapper
                            .map (userSeedDto,User.class))
                    .forEach (this.userRepository::save);
        }
    }

    @Override
    public User findRandomUser () {
        long randomId = ThreadLocalRandom
                .current ()
                .nextLong (1,userRepository.count () + 1);

        return this.userRepository
                .findById (randomId)
                .orElse (null);
    }
}

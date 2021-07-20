package com.example.exc_xml.service.impl;


import com.example.exc_xml.model.dto.UserSeedDto;
import com.example.exc_xml.model.enitity.User;
import com.example.exc_xml.repository.UserRepository;
import com.example.exc_xml.service.UserService;
import com.example.exc_xml.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl (UserRepository userRepository,ModelMapper modelMapper,ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public long getCount () {
        return this.userRepository.count ();
    }

    @Override
    public void seedUsers (List<UserSeedDto> users) {

        users
                .stream ()
                .filter (validationUtil::isValid)
                .map (userSeedDto -> modelMapper.map (userSeedDto,User.class))
                .forEach (userRepository::save);
    }
}

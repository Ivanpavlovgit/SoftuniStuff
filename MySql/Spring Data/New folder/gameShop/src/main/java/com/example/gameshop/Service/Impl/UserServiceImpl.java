package com.example.gameshop.Service.Impl;

import com.example.gameshop.Model.Dto.UserLoginDto;
import com.example.gameshop.Model.Dto.UserRegisterDto;
import com.example.gameshop.Model.Entity.User;
import com.example.gameshop.Repository.UserRepository;
import com.example.gameshop.Service.UserService;
import com.example.gameshop.Util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validator;
    private User loggedInUser;

    public UserServiceImpl (UserRepository userRepository,ModelMapper mapper,ValidationUtil validator) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public void registerUser (UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword ().equals (userRegisterDto.getConfirmPassword ())) {
            System.out.println ("Wrong confirm password");
            return;
        }

        var violations = validator.violation (userRegisterDto);

        if (!violations.isEmpty ()) {
            violations
                    .stream ()
                    .map (ConstraintViolation::getMessage)
                    .forEach (System.out::println);
            return;
        }
        var user = mapper.map (userRegisterDto,User.class);
        userRepository.save (user);
        System.out.printf ("Successfully registered User %s%n",userRegisterDto.getFullName ());
    }

    @Override
    public void loginUser (UserLoginDto userLoginDto) {

        var violations = validator
                .violation (userLoginDto);

        if (!violations.isEmpty ()) {
            violations
                    .stream ()
                    .map (ConstraintViolation::getMessage)
                    .forEach (System.out::println);
            return;
        }
        var user = userRepository.findByEmailAndPassword (
                userLoginDto.getEmail (),
                userLoginDto.getPassword ())
                .orElse (null);
        if (user == null) {
            System.out.println ("Incorrect username / password");
            return;
        }
        loggedInUser = user;
        System.out.printf ("Successfully logged in as %s%n",user.getFullName ());
    }

    @Override
    public void logout () {
        var name=loggedInUser.getFullName ();
        if (loggedInUser == null) {
            System.out.println ("Cannot log out. No user was logged in.");
            return;
        } else {
            loggedInUser = null;
        }
        System.out.printf ("Successfully logged out user %s!%n",name);
    }
}

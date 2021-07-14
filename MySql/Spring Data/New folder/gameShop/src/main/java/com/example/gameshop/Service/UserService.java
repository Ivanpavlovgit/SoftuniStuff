package com.example.gameshop.Service;

import com.example.gameshop.Model.Dto.UserLoginDto;
import com.example.gameshop.Model.Dto.UserRegisterDto;

public interface UserService{
    void registerUser (UserRegisterDto userRegisterDto);

    void loginUser (UserLoginDto userLoginDto);

    void logout ();
}

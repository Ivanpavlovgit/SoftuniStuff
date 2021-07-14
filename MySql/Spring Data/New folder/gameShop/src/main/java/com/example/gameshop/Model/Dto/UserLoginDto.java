package com.example.gameshop.Model.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserLoginDto {
    private String email;
    private String password;

    @Email
    public String getEmail () {
        return this.email;
    }

    public UserLoginDto setEmail (String email) {
        this.email = email;
        return this;
    }

    @Pattern(regexp = "[a-zA-Z\\d]{6,}",
            message = "Password – length must be at least 6 symbols and must contain at least 1 uppercase, 1 lowercase letter and 1 digit")
    public String getPassword () {
        return this.password;
    }

    public UserLoginDto setPassword (String password) {
        this.password = password;
        return this;
    }

    public UserLoginDto () {
    }
}

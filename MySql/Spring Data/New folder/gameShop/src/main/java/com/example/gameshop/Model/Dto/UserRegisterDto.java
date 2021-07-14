package com.example.gameshop.Model.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegisterDto {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    @Email(message = "Enter valid email")
    public String getEmail () {
        return this.email;
    }

    public UserRegisterDto setEmail (String email) {
        this.email = email;
        return this;
    }

    @Pattern(regexp = "[a-zA-Z\\d]{6,}",
            message = "Password – length must be at least 6 symbols and must contain at least 1 uppercase, 1 lowercase letter and 1 digit")
    public String getPassword () {
        return this.password;
    }

    public UserRegisterDto setPassword (String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword () {
        return this.confirmPassword;
    }

    public UserRegisterDto setConfirmPassword (String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Size(min = 2)
    public String getFullName () {
        return this.fullName;
    }

    public UserRegisterDto setFullName (String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserRegisterDto () {
    }

    public UserRegisterDto (String email,String password,String confirmPassword,String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
    }
}

package com.example.gameshop;

import com.example.gameshop.Model.Dto.GameAddDto;
import com.example.gameshop.Model.Dto.UserLoginDto;
import com.example.gameshop.Model.Dto.UserRegisterDto;
import com.example.gameshop.Service.GameService;
import com.example.gameshop.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final BufferedReader reader;
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerImpl (UserService userService,GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.reader = new BufferedReader (new InputStreamReader (System.in));
    }

    @Override
    public void run (String... args) throws Exception {
        while (true) {
            System.out.println ("Hello, Welcome to Exercise : Spring Data Auto Mapping Objects");
            System.out.println ("Please enter a command: ");

            var commands = reader.readLine ().split ("\\|");

            switch (commands[0]) {
                case "RegisterUser" -> userService
                        .registerUser (new UserRegisterDto ()
                                .setEmail (commands[1])
                                .setFullName (commands[4])
                                .setPassword (commands[2])
                                .setConfirmPassword (commands[3]));
                case "LoginUser" -> userService
                        .loginUser (new UserLoginDto ()
                                .setEmail (commands[1])
                                .setPassword (commands[2]));
                case "Logout" -> userService
                        .logout ();
                case "AddGame" -> gameService
                        .addGame (new GameAddDto ()
                                .setTitle (commands[1])
                                .setPrice (new BigDecimal (commands[2]))
                                .setSize (Double.parseDouble (commands[3]))
                                .setTrailer (commands[4])
                                .setThumbnailURL (commands[5])
                                .setDescription (commands[6])
                                .setReleaseDate (commands[7]));
            }
        }
    }
}

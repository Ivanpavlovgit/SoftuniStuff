package com.example.gameshop.Service.Impl;

import com.example.gameshop.Model.Dto.GameAddDto;
import com.example.gameshop.Model.Entity.Game;
import com.example.gameshop.Repository.GameRepository;
import com.example.gameshop.Service.GameService;
import com.example.gameshop.Util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validator;

    public GameServiceImpl (GameRepository gameRepository,ModelMapper mapper,ValidationUtil validator) {
        this.gameRepository = gameRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public void addGame (GameAddDto gameAddDto) {
        var violations = validator.violation (gameAddDto);
        if (!violations.isEmpty ()) {
            violations
                    .stream ()
                    .map (ConstraintViolation::getMessage)
                    .forEach (System.out::println);
            return;
        }
        var game = mapper.map (gameAddDto,Game.class);
        this.gameRepository.save (game);
        System.out.printf ("Successfully save %s game!",game.getTitle ());
    }
}

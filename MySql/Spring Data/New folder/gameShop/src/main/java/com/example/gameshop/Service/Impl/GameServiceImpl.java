package com.example.gameshop.Service.Impl;

import com.example.gameshop.Model.Dto.GameAddDto;
import com.example.gameshop.Model.Entity.Game;
import com.example.gameshop.Repository.GameRepository;
import com.example.gameshop.Service.GameService;
import com.example.gameshop.Util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;

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
        System.out.printf ("Successfully save %s game!",gameAddDto.getTitle ());
    }

    @Override
    public void editGame (Long gameId,BigDecimal price,Double size) {
        var game =
                gameRepository
                        .findById (gameId)
                        .orElse (null);
        if (game == null) {
            System.out.println ("No such game found");
            return;
        }
        game
                .setPrice (price)
                .setSize (size);

        gameRepository.save (game);
        System.out.printf ("Successfully updated %s game to have price of %.2f and size of %.2f!%n",
                game.getTitle (),
                price,
                size);
    }

    @Override
    public void deleteGame (Long gameId) {
        var game = this.gameRepository
                .findById (gameId)
                .orElse (null);

        if (game == null) {
            System.out.println ("No such game found");
            return;
        }

        this.gameRepository
                .deleteById (gameId);
        System.out.printf ("Successfully deleted %s game!%n",game.getTitle ());
    }
}

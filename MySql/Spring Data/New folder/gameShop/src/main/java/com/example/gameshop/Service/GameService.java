package com.example.gameshop.Service;

import com.example.gameshop.Model.Dto.GameAddDto;

import java.math.BigDecimal;

public interface GameService {
    void addGame (GameAddDto gameAddDto);

    void editGame (Long gameId,BigDecimal price,Double size);

    void deleteGame (Long gameId);
}

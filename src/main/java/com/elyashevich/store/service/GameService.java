package com.elyashevich.store.service;

import com.elyashevich.store.dto.gameDto.GameCreateDto;
import com.elyashevich.store.entity.Game;

import java.util.List;

public interface GameService {

    Game create(GameCreateDto gameCreateDto);

    List<Game> findAll();

    void delete(String id);
}

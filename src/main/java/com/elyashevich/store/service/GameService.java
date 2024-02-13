package com.elyashevich.store.service;

import com.elyashevich.store.dto.gameDto.GameCreateDto;
import com.elyashevich.store.dto.gameDto.GameUpdateDto;
import com.elyashevich.store.entity.Game;

import java.io.IOException;
import java.util.List;

public interface GameService {

    Game create(GameCreateDto gameCreateDto);

    Game findById(String id);

    Game update(String id, GameUpdateDto gameUpdateDto);

    List<Game> findAll(String q);

    Game addView(String id);

    void delete(String id);
}

package com.elyashevich.store.service;

import com.elyashevich.store.dto.gameDto.GameCreateDto;
import com.elyashevich.store.dto.imageDto.ImageCreateDto;
import com.elyashevich.store.entity.Game;

import java.io.IOException;
import java.util.List;

public interface GameService {

    Game create(GameCreateDto gameCreateDto, ImageCreateDto imageCreateDto) throws IOException;

    Game findById(String id);

    List<Game> findAll(String q);

    void delete(String id);
}

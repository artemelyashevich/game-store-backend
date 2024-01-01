package com.elyashevich.store.mapper;

import com.elyashevich.store.dto.gameDto.GameCreateDto;
import com.elyashevich.store.entity.Game;
import com.elyashevich.store.entity.Rating;

public class GameMapper {
    public Game convert(final GameCreateDto gameCreateDto) {
        return Game
                .builder()
                .title(gameCreateDto.title())
                .description(gameCreateDto.description())
                .views(0L)
                .rating(Rating
                        .builder()
                        .positive(0L)
                        .negative(0L)
                        .build())
                .build();
    }
}

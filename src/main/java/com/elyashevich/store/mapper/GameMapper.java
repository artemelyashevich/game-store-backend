package com.elyashevich.store.mapper;

import com.elyashevich.store.dto.gameDto.GameCreateDto;
import com.elyashevich.store.dto.gameDto.GameUpdateDto;
import com.elyashevich.store.entity.Game;
import com.elyashevich.store.entity.Rating;
import org.springframework.stereotype.Service;

@Service
public class GameMapper {
    public Game convert(final GameCreateDto gameCreateDto) {
        return Game
                .builder()
                .title(gameCreateDto.title().toLowerCase())
                .description(gameCreateDto.description().toLowerCase())
                .views(0L)
                .rating(Rating
                        .builder()
                        .positive(0L)
                        .negative(0L)
                        .build())
                .imageId(gameCreateDto.imageId())
                .price(gameCreateDto.price())
                .build();
    }

    public Game convertUpdate(final GameUpdateDto gameUpdateDto, final String imageId) {
        return Game
                .builder()
                .title(gameUpdateDto.title().toLowerCase())
                .description(gameUpdateDto.description().toLowerCase())
                .views(0L)
                .rating(gameUpdateDto.rating())
                .imageId(imageId)
                .price(gameUpdateDto.price())
                .build();
    }
}

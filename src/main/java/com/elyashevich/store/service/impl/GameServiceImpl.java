package com.elyashevich.store.service.impl;

import com.elyashevich.store.dto.gameDto.GameCreateDto;
import com.elyashevich.store.dto.imageDto.ImageCreateDto;
import com.elyashevich.store.entity.Game;
import com.elyashevich.store.entity.Image;
import com.elyashevich.store.mapper.GameMapper;
import com.elyashevich.store.repository.GameRepository;
import com.elyashevich.store.service.GameService;
import com.elyashevich.store.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final ImageService imageService;

    @Override
    public Game create(GameCreateDto gameCreateDto, ImageCreateDto imageCreateDto) throws IOException {
        Image image = imageService.create(imageCreateDto);
        final Game game = gameMapper.convert(gameCreateDto, image.getId());
        return gameRepository.save(game);
    }

    @Override
    public List<Game> findAll(String q) {
        if (!q.isEmpty()) {
            return gameRepository.findByQueryTitle(q.toLowerCase());
        }
        return gameRepository.findAll();
    }

    @Override
    public void delete(String id) {
        final Game game = gameRepository.findById(id).orElseThrow();
        gameRepository.delete(game);
    }
}

package com.elyashevich.store.service.impl;

import com.elyashevich.store.dto.gameDto.GameCreateDto;
import com.elyashevich.store.entity.Game;
import com.elyashevich.store.mapper.GameMapper;
import com.elyashevich.store.repository.GameRepository;
import com.elyashevich.store.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    @Override
    public Game create(GameCreateDto gameCreateDto) {
        final Game game = gameMapper.convert(gameCreateDto);
        return gameRepository.save(game);
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void delete(String id) {
        final Game game = gameRepository.findById(id).orElseThrow();
        gameRepository.delete(game);
    }
}

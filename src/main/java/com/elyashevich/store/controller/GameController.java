package com.elyashevich.store.controller;

import com.elyashevich.store.dto.gameDto.GameCreateDto;
import com.elyashevich.store.dto.imageDto.ImageCreateDto;
import com.elyashevich.store.entity.Game;
import com.elyashevich.store.exception.CustomExceptionHandler;
import com.elyashevich.store.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
@RequiredArgsConstructor
@CustomExceptionHandler
public class GameController {

    private final GameService gameService;

    @GetMapping
    public List<Game> findAll(final @RequestParam String q) {
        return gameService.findAll(q);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game create(
            final @RequestBody @Valid GameCreateDto gameCreateDto,
            final @RequestBody @Valid ImageCreateDto imageCreateDto
    ) {
        try {
            return gameService.create(gameCreateDto, imageCreateDto);
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(final @PathVariable String id) {
        gameService.delete(id);
    }
}

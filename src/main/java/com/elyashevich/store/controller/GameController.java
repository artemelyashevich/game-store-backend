package com.elyashevich.store.controller;

import com.elyashevich.store.dto.gameDto.GameCreateDto;
import com.elyashevich.store.dto.imageDto.ImageCreateDto;
import com.elyashevich.store.entity.Game;
import com.elyashevich.store.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
@RequiredArgsConstructor
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
    ) throws IOException {
        return gameService.create(gameCreateDto, imageCreateDto);
    }

    @GetMapping("/{id}")
    public Game findById(final @PathVariable String id) {
        return gameService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(final @PathVariable String id) {
        gameService.delete(id);
    }
}

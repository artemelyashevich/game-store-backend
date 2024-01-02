package com.elyashevich.store.controller;

import com.elyashevich.store.dto.authDto.SignUpDto;
import com.elyashevich.store.dto.imageDto.ImageCreateDto;
import com.elyashevich.store.entity.User;
import com.elyashevich.store.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll(final @RequestParam String q) {
        return userService.findAll(q);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(
            final @RequestBody @Valid SignUpDto signUpDto
            //final @RequestBody @Valid ImageCreateDto imageCreateDto
    ) throws IOException {
        return userService.create(signUpDto/*, imageCreateDto*/);
    }

    @GetMapping("/{id}")
    public User findById(final @PathVariable String id){
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(final @PathVariable String id) {
        userService.delete(id);
    }
}

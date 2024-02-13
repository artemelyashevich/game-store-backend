package com.elyashevich.store.controller;

import com.elyashevich.store.dto.authDto.SignUpDto;
import com.elyashevich.store.dto.userDto.UserUpdateDto;
import com.elyashevich.store.entity.User;
import com.elyashevich.store.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Tag(name = "user_controller")
@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = {"https://6-web-mmf.github.io", "http://127.0.0.1:5173/"})
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll(final @RequestParam String q) {
        return userService.findAll(q);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(final @RequestBody @Valid SignUpDto signUpDto) throws IOException {
        return userService.create(signUpDto);
    }

    @GetMapping("/{id}")
    public User findById(final @PathVariable String id) {
        return userService.findById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(final @RequestBody @Valid UserUpdateDto userUpdateDto, final @PathVariable String id) {
        return userService.update(id, userUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(final @PathVariable String id) {
        userService.delete(id);
    }

    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public User createAdmin(final @RequestBody @Valid SignUpDto signUpDto) {
        return userService.createAdmin(signUpDto);
    }
}

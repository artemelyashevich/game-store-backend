package com.elyashevich.store.controller;

import com.elyashevich.store.dto.authDto.LoginDto;
import com.elyashevich.store.dto.authDto.LoginResponseDto;
import com.elyashevich.store.dto.authDto.SignUpDto;
import com.elyashevich.store.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LoginResponseDto login(final @RequestBody @Valid LoginDto loginDto) {
        return authService.login(loginDto);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponseDto signUp(final @RequestBody @Valid SignUpDto signUpDto) {
        return authService.signUp(signUpDto);
    }

}

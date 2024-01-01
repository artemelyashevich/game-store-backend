package com.elyashevich.store.service;

import com.elyashevich.store.dto.authDto.LoginDto;
import com.elyashevich.store.dto.authDto.LoginResponseDto;
import com.elyashevich.store.dto.authDto.SignUpDto;

public interface AuthService {
    LoginResponseDto login(LoginDto loginDto);
    LoginResponseDto signUp(SignUpDto signUpDto);
}

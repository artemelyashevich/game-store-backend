package com.elyashevich.store.service;

import com.elyashevich.store.dto.authDto.SignUpDto;
import com.elyashevich.store.dto.imageDto.ImageCreateDto;
import com.elyashevich.store.entity.User;

import java.util.List;

public interface UserService {

    User create(SignUpDto signUpDto, ImageCreateDto imageCreateDto) throws java.io.IOException;

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findAll();

    void delete(String id);
}

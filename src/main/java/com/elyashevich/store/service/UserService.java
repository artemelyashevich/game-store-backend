package com.elyashevich.store.service;

import com.elyashevich.store.dto.authDto.SignUpDto;
import com.elyashevich.store.entity.User;

import java.util.List;

public interface UserService {

    User create(SignUpDto signUpDto);

    List<User> findAll();

    void delete(String id);
}

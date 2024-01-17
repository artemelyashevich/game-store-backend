package com.elyashevich.store.service;

import com.elyashevich.store.dto.authDto.SignUpDto;
import com.elyashevich.store.dto.userDto.UserUpdateDto;
import com.elyashevich.store.entity.User;

import java.util.List;

public interface UserService {

    User create(SignUpDto signUpDto/*, ImageCreateDto imageCreateDto*/) throws java.io.IOException;

    User findByUsername(String username);

    User createAdmin(SignUpDto signUpDto);

    User findByEmail(String email);

    User update(String id, UserUpdateDto userUpdateDto);

    User findById(String id);

    List<User> findAll(String q) throws RuntimeException;

    void delete(String id);
}

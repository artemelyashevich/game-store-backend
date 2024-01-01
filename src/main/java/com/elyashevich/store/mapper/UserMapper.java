package com.elyashevich.store.mapper;

import com.elyashevich.store.dto.authDto.SignUpDto;
import com.elyashevich.store.entity.Role;
import com.elyashevich.store.entity.User;

import java.util.List;

public class UserMapper {
    public User convert(final SignUpDto signUpDto, final List<Role> roles) {
        return User
                .builder()
                .username(signUpDto.username())
                .email(signUpDto.email())
                .password(signUpDto.password())
                .roles(roles)
                .build();
    }
}

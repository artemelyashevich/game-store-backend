package com.elyashevich.store.service.impl;

import com.elyashevich.store.dto.authDto.SignUpDto;
import com.elyashevich.store.entity.Role;
import com.elyashevich.store.entity.User;
import com.elyashevich.store.mapper.UserMapper;
import com.elyashevich.store.repository.UserRepository;
import com.elyashevich.store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User create(SignUpDto signUpDto) {
        final List<Role> roles = new ArrayList<>();
        roles.add(Role.ROLE_USER);
        final User user = userMapper.convert(signUpDto, roles);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(String id) {
        final User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }
}

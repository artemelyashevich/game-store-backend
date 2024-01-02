package com.elyashevich.store.service.impl;

import com.elyashevich.store.dto.authDto.SignUpDto;
import com.elyashevich.store.dto.imageDto.ImageCreateDto;
import com.elyashevich.store.entity.Image;
import com.elyashevich.store.entity.Role;
import com.elyashevich.store.entity.User;
import com.elyashevich.store.exception.NotFoundException;
import com.elyashevich.store.mapper.UserMapper;
import com.elyashevich.store.repository.UserRepository;
import com.elyashevich.store.service.ImageService;
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
    private final ImageService imageService;

    @Override
    public User create(SignUpDto signUpDto /*ImageCreateDto imageCreateDto*/) throws java.io.IOException {
        final List<Role> roles = new ArrayList<>();
        roles.add(Role.ROLE_USER);
        //Image image = imageService.create(imageCreateDto);
        final User user = userMapper.convert(signUpDto, roles, "");
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new NotFoundException(String.format("User with username = %s wasn't found!", username))
        );
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new NotFoundException(String.format("User with email = %s wasn't found!", email))
        );
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NotFoundException(String.format("User with id = %s wasn't found!", id))
        );
    }

    @Override
    public List<User> findAll(String q) {
        if (!q.isEmpty()) {
            return userRepository.findByQuery(q);
        }
        return userRepository.findAll();
    }

    @Override
    public void delete(String id) {
        final User user = userRepository.findById(id).orElseThrow(() ->
                new NotFoundException(String.format("User with id = %s wasn't found!", id))
        );
        userRepository.delete(user);
    }
}

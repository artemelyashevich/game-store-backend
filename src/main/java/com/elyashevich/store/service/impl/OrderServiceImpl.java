package com.elyashevich.store.service.impl;

import com.elyashevich.store.dto.orderDto.OrderCreateDto;
import com.elyashevich.store.entity.Game;
import com.elyashevich.store.entity.Order;
import com.elyashevich.store.entity.User;
import com.elyashevich.store.mapper.OrderMapper;
import com.elyashevich.store.repository.GameRepository;
import com.elyashevich.store.repository.OrderRepository;
import com.elyashevich.store.repository.UserRepository;
import com.elyashevich.store.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final OrderMapper orderMapper;

    @Override
    public Order create(OrderCreateDto orderCreateDto) {
        final User user = userRepository.findById(orderCreateDto.userId()).orElseThrow();
        final Game game = gameRepository.findById(orderCreateDto.gameId()).orElseThrow();
        final Order order = orderMapper.convert(orderCreateDto);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(String id) {
        final Order order = orderRepository.findById(id).orElseThrow();
        orderRepository.delete(order);
    }
}

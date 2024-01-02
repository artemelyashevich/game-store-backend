package com.elyashevich.store.service;

import com.elyashevich.store.dto.orderDto.OrderCreateDto;
import com.elyashevich.store.entity.Order;

import java.util.List;

public interface OrderService {

    Order create(OrderCreateDto orderCreateDto);

    List<Order> findAll();

    Order findById(String id);

    /* @Todo implements purchase method */

    Order purchase();

    void delete(String id);
}

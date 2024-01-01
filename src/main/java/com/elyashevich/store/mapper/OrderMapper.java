package com.elyashevich.store.mapper;

import com.elyashevich.store.dto.orderDto.OrderCreateDto;
import com.elyashevich.store.entity.Order;

public class OrderMapper {
    public Order convert(final OrderCreateDto orderCreateDto) {
        return Order
                .builder()
                .userId(orderCreateDto.userId())
                .gameId(orderCreateDto.gameId())
                .build();
    }
}

package com.elyashevich.store.repository;

import com.elyashevich.store.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}

package com.elyashevich.store.repository;

import com.elyashevich.store.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

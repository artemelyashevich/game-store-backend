package com.elyashevich.store.repository;

import com.elyashevich.store.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    @Query("{username:{$regex:?0}}")
    List<User> findByQuery(String q);
}

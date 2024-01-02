package com.elyashevich.store.repository;

import com.elyashevich.store.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Optional<Category> findByTitle(String title);
}

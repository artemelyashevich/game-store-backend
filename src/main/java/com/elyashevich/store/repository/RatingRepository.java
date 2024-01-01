package com.elyashevich.store.repository;

import com.elyashevich.store.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Rating, String> {
}

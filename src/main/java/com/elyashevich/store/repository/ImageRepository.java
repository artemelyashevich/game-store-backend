package com.elyashevich.store.repository;

import com.elyashevich.store.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {
}

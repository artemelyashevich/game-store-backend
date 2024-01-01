package com.elyashevich.store.repository;

import com.elyashevich.store.mapping.CommentMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<CommentMapping, String> {
}

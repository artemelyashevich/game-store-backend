package com.elyashevich.store.repository;

import com.elyashevich.store.entity.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {
}

package com.elyashevich.store.repository;

import com.elyashevich.store.entity.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GameRepository extends MongoRepository<Game, String> {

    @Query("{title:{$regex:?0}}")
    List<Game> findByQueryTitle(String q);
}

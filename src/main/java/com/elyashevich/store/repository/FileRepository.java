package com.elyashevich.store.repository;

import com.elyashevich.store.entity.FileData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FileRepository extends MongoRepository<FileData, String> {

    Optional<FileData> findByName(String name);
}

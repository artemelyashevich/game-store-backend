package com.elyashevich.store.service;

import com.elyashevich.store.dto.categoryDto.CategoryCreateDto;
import com.elyashevich.store.entity.Category;

import java.util.List;

public interface CategoryService {

    Category create(CategoryCreateDto categoryCreateDto);

    Category findById(String id);

    Category findByTitle(String title);

    List<Category> findAll();

    void delete(String id);
}

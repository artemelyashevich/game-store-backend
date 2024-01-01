package com.elyashevich.store.mapper;

import com.elyashevich.store.dto.categoryDto.CategoryCreateDto;
import com.elyashevich.store.entity.Category;

public class CategoryMapper {
    public Category convert(final CategoryCreateDto categoryCreateDto) {
        return Category
                .builder()
                .title(categoryCreateDto.title())
                .build();
    }
}

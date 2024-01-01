package com.elyashevich.store.service.impl;

import com.elyashevich.store.dto.categoryDto.CategoryCreateDto;
import com.elyashevich.store.entity.Category;
import com.elyashevich.store.mapper.CategoryMapper;
import com.elyashevich.store.repository.CategoryRepository;
import com.elyashevich.store.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Category create(CategoryCreateDto categoryCreateDto) {
        final Category category = categoryMapper.convert(categoryCreateDto);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(String id) {
        final Category category = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(category);
    }
}

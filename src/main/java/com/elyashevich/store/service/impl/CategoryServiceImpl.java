package com.elyashevich.store.service.impl;

import com.elyashevich.store.dto.categoryDto.CategoryCreateDto;
import com.elyashevich.store.entity.Category;
import com.elyashevich.store.exception.NotFoundException;
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
    public Category findById(String id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                new NotFoundException(String.format("Category with id = %s wasn't found", id)));
    }

    @Override
    public Category findByTitle(String title) {
        return categoryRepository.findByTitle(title).orElseThrow(() ->
                new NotFoundException(String.format("Category with title = %s wasn't found", title)));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(CategoryCreateDto categoryCreateDto) {
        return null;
    }

    @Override
    public void delete(String id) {
        final Category category = categoryRepository.findById(id).orElseThrow(() ->
                new NotFoundException(String.format("Category with id = %s wasn't found", id)));
        categoryRepository.delete(category);
    }
}

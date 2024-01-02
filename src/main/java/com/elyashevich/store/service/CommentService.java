package com.elyashevich.store.service;

import com.elyashevich.store.dto.commentDto.CommentCreateDto;
import com.elyashevich.store.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment create(CommentCreateDto commentCreateDto);

    Comment findById(String id);

    List<Comment> findAll();

    void delete(String id);
}

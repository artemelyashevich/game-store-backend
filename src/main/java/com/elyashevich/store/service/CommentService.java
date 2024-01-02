package com.elyashevich.store.service;

import com.elyashevich.store.dto.commentDto.CommentCreateDto;
import com.elyashevich.store.dto.commentDto.CommentUpdateDto;
import com.elyashevich.store.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment create(CommentCreateDto commentCreateDto);

    Comment findById(String id);

    Comment update(String id, CommentUpdateDto commentUpdateDto);

    List<Comment> findAll();

    void delete(String id);
}

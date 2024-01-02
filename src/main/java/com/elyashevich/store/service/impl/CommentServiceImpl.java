package com.elyashevich.store.service.impl;

import com.elyashevich.store.dto.commentDto.CommentCreateDto;
import com.elyashevich.store.entity.Comment;
import com.elyashevich.store.exception.NotFoundException;
import com.elyashevich.store.mapper.CommentMapper;
import com.elyashevich.store.repository.CommentRepository;
import com.elyashevich.store.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public Comment create(CommentCreateDto commentCreateDto) {
        final Comment comment = commentMapper.convert(commentCreateDto);
        return commentRepository.save(comment);
    }

    @Override
    public Comment findById(String id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new NotFoundException(String.format("Comment with id = %s wasn't found", id)));
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void delete(String id) {
        final Comment comment = commentRepository.findById(id).orElseThrow();
        commentRepository.delete(comment);
    }
}

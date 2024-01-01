package com.elyashevich.store.mapper;

import com.elyashevich.store.dto.commentDto.CommentCreateDto;
import com.elyashevich.store.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentMapper {
    public Comment convert(final CommentCreateDto commentCreateDto) {
        return Comment
                .builder()
                .gameId(commentCreateDto.gameId())
                .creatorId(commentCreateDto.creatorId())
                .text(commentCreateDto.text())
                .build();
    }
}

package com.elyashevich.store.dto.commentDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommentCreateDto(

        @NotBlank(message = "Invalid Text: Empty text")
        @NotNull(message = "Invalid Text: Text is NULL")
        @Size(min = 2, message = "Invalid Text: Must be more then 2 characters")
        String text,

        @NotBlank(message = "Invalid GameId: Empty gameId")
        @NotNull(message = "Invalid GameId: GameId is NULL")
        String gameId,

        @NotBlank(message = "Invalid CreatorId: Empty creatorId")
        @NotNull(message = "Invalid CreatorId: Text is NULL")
        String creatorId
) {
}

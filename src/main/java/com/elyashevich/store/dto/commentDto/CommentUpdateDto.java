package com.elyashevich.store.dto.commentDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommentUpdateDto(

        @NotBlank(message = "Invalid Text: Empty text")
        @NotNull(message = "Invalid Text: Text is NULL")
        @Size(min = 2, message = "Invalid Text: Must be more then 2 characters")
        String text
) {
}

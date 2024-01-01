package com.elyashevich.store.dto.categoryDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryCreateDto(

        @NotBlank(message = "Invalid Title: Empty title")
        @NotNull(message = "Invalid Title: Title is NULL")
        @Size(min = 2, max = 30, message = "Invalid Title: Must be of 2 - 30 characters")
        String title
) {
}

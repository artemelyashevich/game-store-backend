package com.elyashevich.store.dto.gameDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record GameCreateDto(

        @NotBlank(message = "Invalid Title: Empty title")
        @NotNull(message = "Invalid Title: Title is NULL")
        @Size(min = 3, max = 50, message = "Invalid Name: Must be of 3 - 50 characters")
        String title,

        @NotBlank(message = "Invalid Description: Empty description")
        @NotNull(message = "Invalid Description: Description is NULL")
        String description
) {
}

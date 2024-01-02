package com.elyashevich.store.dto.gameDto;

import com.elyashevich.store.entity.Rating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record GameUpdateDto(

        @NotBlank(message = "Invalid Title: Empty title")
        @NotNull(message = "Invalid Title: Title is NULL")
        @Size(min = 3, max = 50, message = "Invalid Name: Must be of 3 - 50 characters")
        String title,

        @NotBlank(message = "Invalid Description: Empty description")
        @NotNull(message = "Invalid Description: Description is NULL")
        String description,

        @NotBlank(message = "Invalid Rating: Empty rating")
        @NotNull(message = "Invalid Rating: Rating is NULL")
        Rating rating,

        @NotBlank(message = "Invalid Views: Empty views")
        @NotNull(message = "Invalid Views: Views is NULL")
        Long views,

        @NotBlank(message = "Invalid Price: Empty price")
        @NotNull(message = "Invalid Price: Price is NULL")
        Double price
) {
}

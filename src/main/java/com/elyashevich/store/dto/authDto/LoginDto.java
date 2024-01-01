package com.elyashevich.store.dto.authDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginDto(

        @NotBlank(message = "Invalid Username: Empty username")
        @NotNull(message = "Invalid Username: Username is NULL")
        String username,

        @NotBlank(message = "Invalid Password: Empty password")
        @NotNull(message = "Invalid Password: Password is NULL")
        String password
) {
}

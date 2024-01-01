package com.elyashevich.store.dto.orderDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderCreateDto(

        @NotBlank(message = "Invalid GameId: Empty gameId")
        @NotNull(message = "Invalid GameId: GameId is NULL")
        String gameId,

        @NotBlank(message = "Invalid UserId: Empty userId")
        @NotNull(message = "Invalid UserId: UserId is NULL")
        String userId
) {
}

package com.elyashevich.store.dto.imageDto;

import org.springframework.web.multipart.MultipartFile;

public record ImageCreateDto(
        String title,
        MultipartFile file
) {
}

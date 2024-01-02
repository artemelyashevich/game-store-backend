package com.elyashevich.store.service;

import com.elyashevich.store.dto.imageDto.ImageCreateDto;
import com.elyashevich.store.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    Image create(ImageCreateDto imageCreateDto) throws IOException;

    Image findById(String id);
}

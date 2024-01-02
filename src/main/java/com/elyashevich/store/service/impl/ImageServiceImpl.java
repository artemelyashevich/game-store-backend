package com.elyashevich.store.service.impl;

import com.elyashevich.store.dto.imageDto.ImageCreateDto;
import com.elyashevich.store.entity.Image;
import com.elyashevich.store.repository.ImageRepository;
import com.elyashevich.store.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public Image create(ImageCreateDto imageCreateDto) throws IOException {
        Image image = Image
                .builder()
                .title(imageCreateDto.title())
                .file(new Binary(BsonBinarySubType.BINARY, imageCreateDto.file().getBytes()))
                .build();
        image = imageRepository.insert(image);
        return image;
    }

    @Override
    public Image findById(String id) {
        return imageRepository.findById(id).orElseThrow();
    }
}

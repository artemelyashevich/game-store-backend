package com.elyashevich.store.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    void upload(MultipartFile multipartFile) throws IOException;

    byte[] downloadFile(String fileName) throws IOException;
}

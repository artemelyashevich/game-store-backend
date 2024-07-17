package com.elyashevich.store.service.impl;

import com.elyashevich.store.entity.FileData;
import com.elyashevich.store.repository.FileRepository;
import com.elyashevich.store.service.FileService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Value("${application.files.path}")
    private String PATH_TO_FOLDER;

    @Override
    public void upload(MultipartFile multipartFile) throws IOException {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
        String filePath = this.PATH_TO_FOLDER + date + multipartFile.getOriginalFilename();
        System.out.println(filePath);
        multipartFile.transferTo(new File(filePath));
    }

    @Override
    public byte[] downloadFile(String fileName) throws IOException {
        FileData fileData = this.fileRepository.findByName(fileName)
                .orElseThrow(() -> new NoSuchElementException("No such file here..."));
        return Files.readAllBytes(new File(fileData.getFilePath()).toPath());
    }
}

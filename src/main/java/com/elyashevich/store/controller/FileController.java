package com.elyashevich.store.controller;

import com.elyashevich.store.service.FileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Map;

@Tag(name = "comment_controller")
@RestController
@RequestMapping("/api/v1/files")
@CrossOrigin(origins = {"https://6-web-mmf.github.io", "http://127.0.0.1:5173/"})
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<String> uploadFile(
            @RequestParam MultipartFile file
    ) throws IOException {
        this.fileService.upload(file);
        return ResponseEntity
                .ok()
                .build();
    }
}

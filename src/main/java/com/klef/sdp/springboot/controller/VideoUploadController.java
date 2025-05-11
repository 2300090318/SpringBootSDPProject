package com.klef.sdp.springboot.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import org.springframework.http.HttpStatus;
import java.util.Arrays;


import java.io.IOException;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin("*")
public class VideoUploadController {

    private static final String VIDEO_DIR = "videos";

    @PostMapping("/upload")
    public String uploadVideo(@RequestParam("video") MultipartFile video) {
        try {
            Path uploadPath = Paths.get(VIDEO_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(video.getOriginalFilename());
            Files.copy(video.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return "Video uploaded successfully";
        } catch (IOException e) {
            return "Failed to upload video";
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllVideos() {
        File dir = new File("videos");

        if (!dir.exists()) {
            dir.mkdirs();
            return ResponseEntity.ok(Collections.emptyList());
        }

        String[] files = dir.list((d, name) -> name.endsWith(".mp4"));

        if (files == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        List<String> videoUrls = Arrays.stream(files)
                .map(name -> "/videos/" + name)
                .collect(Collectors.toList());

        return ResponseEntity.ok(videoUrls);
    }


    @GetMapping("/stream/{filename}")
    public ResponseEntity<Resource> streamVideo(@PathVariable String filename) throws IOException {
        Path videoPath = Paths.get(VIDEO_DIR).resolve(filename);
        Resource resource = new UrlResource(videoPath.toUri());

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "video/mp4");

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
}

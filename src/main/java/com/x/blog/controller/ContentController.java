package com.x.blog.controller;

import com.x.blog.model.Content;
import com.x.blog.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/blog/content")
@RequiredArgsConstructor
public class ContentController {
    private final ContentService contentService;

    @PostMapping("/create")
    public Mono<Content> createContent(@RequestBody Content content) {
        return contentService.craeteContent(content);
    }
    // get all contents
    @GetMapping("/all")
    public Flux<Content> getAllContents() {
        return contentService.getAllContents();
    }
}

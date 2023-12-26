package com.x.blog.service;

import com.x.blog.model.Content;
import com.x.blog.repo.ContentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepo contentRepo;

    public Mono<Content> craeteContent(Content content) {
        // create id based on title and time minutes
//        content.setId(content.getTitle().hashCode() + (int) (System.currentTimeMillis() / 1000 / 60));
        // create id based on CONTENT:: and time minutes
        content.setId("CONTENT::" + (int)(System.currentTimeMillis() / 1000 / 60));
        log.info("ContentService.craeteContent: {}", content);
        return contentRepo.save(content);

    }

    public Flux<Content> getAllContents() {
        return contentRepo.findAll();
    }
}

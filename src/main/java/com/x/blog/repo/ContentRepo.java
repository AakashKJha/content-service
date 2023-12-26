package com.x.blog.repo;

import com.x.blog.model.Content;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

public interface ContentRepo extends ReactiveCouchbaseRepository<Content, Integer> {
}

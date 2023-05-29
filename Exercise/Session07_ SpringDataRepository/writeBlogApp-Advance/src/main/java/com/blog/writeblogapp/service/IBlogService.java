package com.blog.writeblogapp.service;

import com.blog.writeblogapp.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findAll();

    Blog findById(Long id);

    void remove(Long id);

    void save(Blog blog);
    List<Blog> findByCatalogId(Long id);
}

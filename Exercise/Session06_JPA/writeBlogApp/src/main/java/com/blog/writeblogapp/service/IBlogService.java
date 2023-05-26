package com.blog.writeblogapp.service;

import com.blog.writeblogapp.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void remove(Long id);

    void save(Blog blog);
}

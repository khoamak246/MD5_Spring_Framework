package com.blog.writeblogapp.repository;

import com.blog.writeblogapp.model.Blog;

import java.util.List;

public interface IBlogRepository {

    List<Blog> findAll();

    Blog findById(Long id);

    void remove(Long id);

    void save(Blog blog);

}

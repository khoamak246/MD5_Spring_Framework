package com.ajax_blog.service;

import com.ajax_blog.model.Blog;
import com.ajax_blog.service.design.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService extends IGenericService<Blog> {
    List<Blog> findByTitleContaining(String title);

    Page<Blog> findAll(Pageable pageable);
}

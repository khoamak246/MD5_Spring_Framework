package com.blog.writeblogapp.service;

import com.blog.writeblogapp.model.Blog;
import com.blog.writeblogapp.model.Catalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICatalogService {
    List<Catalog> findAll();

    Catalog findById(Long id);

    void remove(Long id);

    void save(Catalog catalog);
}

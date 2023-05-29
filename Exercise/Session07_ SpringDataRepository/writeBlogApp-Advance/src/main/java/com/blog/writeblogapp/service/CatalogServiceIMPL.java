package com.blog.writeblogapp.service;

import com.blog.writeblogapp.model.Blog;
import com.blog.writeblogapp.model.Catalog;
import com.blog.writeblogapp.repository.IBlogRepository;
import com.blog.writeblogapp.repository.ICatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceIMPL implements ICatalogService{

    @Autowired
    private ICatalogRepository catalogRepository;

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog findById(Long id) {
        return catalogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        catalogRepository.deleteById(id);
    }

    @Override
    public void save(Catalog catalog) {
        catalogRepository.save(catalog);
    }
}

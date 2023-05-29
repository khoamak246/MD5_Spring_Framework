package com.ajax_blog.service.serviceIMPL;

import com.ajax_blog.model.Catalog;
import com.ajax_blog.repository.ICatalogRepository;
import com.ajax_blog.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogServiceIMPL implements ICatalogService {

    @Autowired
    private ICatalogRepository catalogRepository;

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Optional<Catalog> findById(Long id) {
        return catalogRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        catalogRepository.deleteById(id);
    }

    @Override
    public Catalog save(Catalog catalog) {
        return catalogRepository.save(catalog);
    }
}

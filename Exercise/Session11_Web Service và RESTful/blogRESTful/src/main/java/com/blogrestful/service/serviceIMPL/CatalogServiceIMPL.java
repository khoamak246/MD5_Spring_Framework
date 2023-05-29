package com.blogrestful.service.serviceIMPL;

import com.blogrestful.model.Catalog;
import com.blogrestful.repository.ICatalogRepository;
import com.blogrestful.service.ICatalogService;
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

package com.ajax_blog.controller;


import com.ajax_blog.model.Catalog;
import com.ajax_blog.model.ResponeObject;
import com.ajax_blog.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/catalog")
@CrossOrigin(origins = "*")
public class CatalogController {

    @Autowired
    private ICatalogService catalogService;

    @GetMapping("")
    public ResponseEntity<ResponeObject> getAllCatalog() {
        List<Catalog> catalogs = catalogService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponeObject("ok", "Query Successfully!", catalogs));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponeObject> getCatalogById(@PathVariable Long id) {
        Optional<Catalog> catalogOptional = catalogService.findById(id);
        return catalogOptional.isPresent()
                ? ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("ok", "Query Successfully!", catalogOptional))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("fail", "Cannot find catalog with id = " + id, ""));
    }

    @PostMapping("")
    public ResponseEntity<ResponeObject> postForCatalog(@RequestBody Catalog catalog) {
       Catalog newCatalog = catalogService.save(catalog);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponeObject("ok", "Post catalog successfully!", newCatalog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponeObject> putForCatalog(@RequestBody Catalog catalog, @PathVariable Long id) {
        Optional<Catalog> catalogOptional = catalogService.findById(id);
        return catalogOptional.isPresent()
                ? ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("ok", "Update catalog successfully!", catalogService.save(catalog)))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("fail", "Cannot find catalog with id = " + id, ""));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponeObject> deleteForCatalog(@PathVariable Long id) {
        Optional<Catalog> catalogOptional = catalogService.findById(id);
        return catalogOptional.isPresent()
                ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok", "Delete catalog successfully!", ""))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponeObject("fail", "Cannot find catalog with id = " + id, ""));
    }

}

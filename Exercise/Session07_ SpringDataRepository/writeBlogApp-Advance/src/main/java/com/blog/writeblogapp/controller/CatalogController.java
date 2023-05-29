package com.blog.writeblogapp.controller;


import com.blog.writeblogapp.model.Blog;
import com.blog.writeblogapp.model.Catalog;
import com.blog.writeblogapp.service.IBlogService;
import com.blog.writeblogapp.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CatalogController {

    @Autowired
    private ICatalogService catalogService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("/catalog-list")
    public String showCatalogList(Model model) {
        model.addAttribute("catalogs", catalogService.findAll());
        return "catalogList";
    }

    @GetMapping("/create-catalog")
    public String showCreateCatalog(Model model) {
        model.addAttribute("catalog", new Catalog());
        return "createCatalog";
    }

    @PostMapping("/save-catalog")
    public String saveCatalog(@ModelAttribute Catalog catalog) {
        catalogService.save(catalog);
        return "redirect:/catalog-list";
    }

    @GetMapping("/edit-catalog/{id}")
    public String showEditCatalog(@PathVariable("id") Catalog catalog, Model model) {
        model.addAttribute("catalog", catalog);
        return "editCatalog";
    }

    @PostMapping("/catalog-edit")
    public String editCatalog(@ModelAttribute Catalog catalog) {
        catalogService.save(catalog);
        return "redirect:/catalog-list";
    }

    @GetMapping("/delete-catalog/{id}")
    public String deleteCatalog(@PathVariable("id") Long id) {
        List<Blog> blogs = blogService.findByCatalogId(id);
        for (Blog blog: blogs) {
            blog.setCatalog(null);
            blogService.save(blog);
        }
        catalogService.remove(id);
        return "redirect:/catalog-list";
    }

}

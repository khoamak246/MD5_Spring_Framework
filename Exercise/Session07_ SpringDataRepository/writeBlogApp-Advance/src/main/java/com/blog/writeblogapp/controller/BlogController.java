package com.blog.writeblogapp.controller;

import com.blog.writeblogapp.model.Blog;
import com.blog.writeblogapp.service.IBlogService;
import com.blog.writeblogapp.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICatalogService catalogService;

    @GetMapping("/")
    public String showIndex(Model model) {
        return "redirect:/page/0";
    }

    @GetMapping("/page/{page}")
    public String showPage(@PathVariable int page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Blog> blogs = blogService.findAll(pageable);
        model.addAttribute("blogs", blogs);
        return "index";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable Long id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "detail";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("catalogs", catalogService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog) {
        blog.setPostDate(LocalDate.now());
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(Model model, @PathVariable Long id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("catalogs", catalogService.findAll());
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogService.remove(id);
        return "redirect:/";
    }

}

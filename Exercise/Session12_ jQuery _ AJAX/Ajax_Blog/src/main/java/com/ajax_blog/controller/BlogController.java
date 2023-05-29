package com.ajax_blog.controller;


import com.ajax_blog.model.Blog;
import com.ajax_blog.model.ResponeObject;
import com.ajax_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/blog")
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<ResponeObject> getAllBlog() {
        List<Blog> blogs = blogService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok", "Query Successfully!", blogs)
        );
    }

    @GetMapping("/page/{number}")
    public ResponseEntity<ResponeObject> getPageBlog(@PathVariable int number) {
        Pageable page = PageRequest.of(number, 20);
        Page<Blog> blogs = blogService.findAll(page);
        List<Blog> blogList = blogs.getContent();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok", "Query Successfully!", blogList)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponeObject> getBlogById(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        return blogOptional.map(blog -> ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("ok", "Query Successfully!", blog)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("fail", "Cannot find blog with id = " + id, "")));
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<ResponeObject> getBlogByTitle(@PathVariable String title) {
        List<Blog> blogs = blogService.findByTitleContaining(title);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok", "Query Successfully!", blogs));
    }

    @PostMapping("")
    public ResponseEntity<ResponeObject> postForBlog(@RequestBody Blog blog) {
        Blog newBlog = blogService.save(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponeObject("ok", "Post blog successfully!", newBlog)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponeObject> putForBlog(@RequestBody Blog blog, @PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        return blogOptional.isPresent()
                ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok", "Update blog successfully!", blogService.save(blog)))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponeObject("fail", "Cannot find blog with id = " + id, ""));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponeObject> deleteForBlog(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        return blogOptional.isPresent()
                ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("ok", "Delete blog successfully!", ""))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponeObject("fail", "Cannot find product with id = " + id, ""));
    }
}

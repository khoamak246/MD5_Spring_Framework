package com.blogrestful.controller;


import com.blogrestful.model.Blog;
import com.blogrestful.service.IBlogService;
import com.google.protobuf.LazyStringList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public List<Blog> findALlBlog() {
        return blogService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findByBlogId(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        return blogOptional.map(blog ->
                        new ResponseEntity<>(blog, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blogOptional) {
        return new ResponseEntity<>(blogService.save(blogOptional), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateCustomer(@PathVariable Long id, @RequestBody Blog blog) {
        Optional<Blog> customerOptional = blogService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setBlogId(customerOptional.get().getBlogId());
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteCustomer(@PathVariable Long id) {
        Optional<Blog> customerOptional = blogService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.deleteById(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }

}

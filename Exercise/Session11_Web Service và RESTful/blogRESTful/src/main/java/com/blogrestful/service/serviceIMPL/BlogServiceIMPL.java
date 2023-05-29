package com.blogrestful.service.serviceIMPL;

import com.blogrestful.model.Blog;
import com.blogrestful.repository.IBlogRepository;
import com.blogrestful.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceIMPL implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }
}

package com.ajax_blog.repository;

import com.ajax_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByTitleContaining(String title);
}

package com.blog.writeblogapp.repository;

import com.blog.writeblogapp.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByCatalogCatalogId(Long id);
}

package com.blog.writeblogapp.repository;

import com.blog.writeblogapp.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatalogRepository extends JpaRepository<Catalog, Long> {
}

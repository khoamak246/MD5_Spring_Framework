package com.blog.writeblogapp.repository;

import com.blog.writeblogapp.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepositoryIMPL implements IBlogRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        String hql = "select b from Blog b";
        TypedQuery<Blog> blog = entityManager.createQuery(hql, Blog.class);
        return blog.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        String hql = "select b from Blog b where b.id = :id";
        TypedQuery<Blog> blog = entityManager.createQuery(hql, Blog.class);
        blog.setParameter("id", id);
        try {
            return blog.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if (blog != null)
            entityManager.remove(blog);
    }

    @Override
    public void save(Blog blog) {
        Blog tempBlog = findById(blog.getId());
        if (tempBlog != null)
            entityManager.merge(blog);
        else
            entityManager.persist(blog);
    }
}

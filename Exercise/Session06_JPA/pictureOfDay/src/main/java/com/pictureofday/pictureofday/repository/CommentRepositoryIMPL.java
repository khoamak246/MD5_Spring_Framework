package com.pictureofday.pictureofday.repository;

import com.pictureofday.pictureofday.model.Comment;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Transactional
public class CommentRepositoryIMPL implements ICommentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> findALl() {
        String hql = "select c from Comment c where c.date = :date";
        TypedQuery<Comment> comment = entityManager.createQuery(hql, Comment.class);
        comment.setParameter("date", LocalDate.now());
        return comment.getResultList();
    }

    @Override
    public Comment findById(Long id) {
        String hql = "select c from Comment c where c.id = :id";
        TypedQuery<Comment> comment = entityManager.createQuery(hql, Comment.class);
        comment.setParameter("id", id);
        try {
            return comment.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        Comment comment = findById(id);
        if (comment != null)
            entityManager.remove(comment);
    }

    @Override
    public void save(Comment comment) {
        Comment tempComment = findById(comment.getId());
        if (tempComment != null)
            entityManager.merge(comment);
        else
            entityManager.persist(comment);
    }
}

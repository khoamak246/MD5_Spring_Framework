package com.pictureofday.pictureofday.services;

import com.pictureofday.pictureofday.models.Comment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CommentServiceIMPL implements ICommentServices {

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> findAll() {
        String hql = "select c from Comment c where c.date = :date";
        TypedQuery<Comment> commentQuery = entityManager.createQuery(hql, Comment.class);
        commentQuery.setParameter("date", LocalDate.now());
        return commentQuery.getResultList();
    }

    @Override
    public Comment findById(Long id) {
        String hql = "select c from Comment c where c.id = :id";
        TypedQuery<Comment> comment = entityManager.createQuery(hql, Comment.class);
        comment.setParameter("id", id);
        return comment.getSingleResult();
    }

    @Override
    public void deleteById(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(findById(id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void save(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (comment.getId() != null) {
                Comment tempAudio = findById(comment.getId());
                tempAudio.clone(comment);
            }
            session.saveOrUpdate(comment);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}

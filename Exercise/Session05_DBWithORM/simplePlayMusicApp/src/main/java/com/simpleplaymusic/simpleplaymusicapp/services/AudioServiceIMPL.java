package com.simpleplaymusic.simpleplaymusicapp.services;

import com.simpleplaymusic.simpleplaymusicapp.models.Audio;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AudioServiceIMPL implements IAudioService{

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
    public List<Audio> findAll() {
        String hql = "select a from Audio a";
        TypedQuery<Audio> audioQuery = entityManager.createQuery(hql, Audio.class);
        return audioQuery.getResultList();
    }

    @Override
    public Audio findById(Long id) {
        String hql = "select a from Audio a where a.id = :id";
        TypedQuery<Audio> audio = entityManager.createQuery(hql, Audio.class);
        audio.setParameter("id", id);
        return audio.getSingleResult();
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
    public void save(Audio audio) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (audio.getId() != null) {
                Audio tempAudio = findById(audio.getId());
                tempAudio.clone(audio);
            }
            session.saveOrUpdate(audio);
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

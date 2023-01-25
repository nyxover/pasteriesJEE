package com.training.pastries.dao;

import com.training.pastries.JPAUtil;
import com.training.pastries.dao.entity.Pastry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PastryJpaDao implements PastryDao {
    @Override
    public void save(Pastry pastry) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(pastry);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }

    }
    @Override
    public Optional<Pastry> get(Long id) {
        Optional<Pastry> result = Optional.empty();
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            result = Optional.of(em.find(Pastry.class, id));
            et.commit();
        } catch (Exception e) {
            if (et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return result;
    }

    @Override
    public List<Pastry> getAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        List<Pastry> pastries = new ArrayList<>();
        et.begin();
        try {
            TypedQuery<Pastry> pastriesQuery = em.createQuery("SELECT p FROM Pastry p", Pastry.class);
            pastries = pastriesQuery.getResultList();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return pastries;
    }


    @Override
    public void update(Pastry pastry) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(pastry);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }

    }

    @Override
    public void delete(Pastry pastry) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.remove(em.contains(pastry) ? pastry : em.merge(pastry));
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }

    }
}
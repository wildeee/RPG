package com.rpg.ranking;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAO {

    public static void insere(Rank r) {
        final EntityManager em = Connection.getEntityManager();
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
    }

    public static List<Rank> getAll() {
        final EntityManager em = Connection.getEntityManager();
        Query q = em.createQuery("SELECT r FROM Rank r ORDER BY r.score DESC");
        return q.getResultList();

    }
}

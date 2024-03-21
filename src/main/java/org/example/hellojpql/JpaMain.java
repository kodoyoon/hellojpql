package org.example.hellojpql;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;


public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member1 = new Member();
            member1.setUsername("관리자1");
           em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("관리자2");
             em.persist(member2);

            em.flush();
            em.clear();

            String query = "select t.memebrs From Team t";

            Collection result = em.createQuery(query, Collection.class)
                .getResultList();

            for (Object o : result) {
                System.out.println("o = " + o);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }

}

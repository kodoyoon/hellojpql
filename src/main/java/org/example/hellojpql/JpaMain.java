package org.example.hellojpql;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member= new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

           TypedQuery<Member> query = em.createQuery("select m from Member  m", Member.class); //Typequery : 반환 타입이 명확할때 사용



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

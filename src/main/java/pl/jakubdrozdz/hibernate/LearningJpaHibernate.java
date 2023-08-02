package pl.jakubdrozdz.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LearningJpaHibernate {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2_db");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    public static void main(String[] args) {
        System.out.println(LearningJpaHibernate.class.getName());
    }
}

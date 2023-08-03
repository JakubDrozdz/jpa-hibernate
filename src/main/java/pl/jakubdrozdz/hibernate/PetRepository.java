package pl.jakubdrozdz.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PetRepository {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2_db");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void createNewPet(String name, int age){
        System.out.println("-----New pet creation-----");
        EntityTransaction transaction = entityManager.getTransaction();
        Pet pet = new Pet(name, age);
        transaction.begin();
        //save in persistence context
        entityManager.persist(pet);
        System.out.println("New pet ID: " + pet.getId());
        transaction.commit();
        System.out.println("Pet with ID: " + pet.getId() + " saved to DB");
    }

    public Pet findById(int id){
        //entityManager.clear();
        System.out.println("-----Find pet with ID: " + id + "-----");
        return entityManager.find(Pet.class, id);
    }
}

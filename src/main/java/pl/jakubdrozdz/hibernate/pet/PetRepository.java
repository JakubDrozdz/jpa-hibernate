package pl.jakubdrozdz.hibernate.pet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import pl.jakubdrozdz.hibernate.pet.exception.PetNotFoundException;

public class PetRepository {
    private EntityManager entityManager;
    public PetRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public Pet createNewPet(String name, int age){
        System.out.println("-----New pet creation-----");
        EntityTransaction transaction = entityManager.getTransaction();
        Pet pet = new Pet(name, age);
        transaction.begin();
        //save in persistence context
        entityManager.persist(pet);
        System.out.println("New pet ID: " + pet.getId());
        transaction.commit();
        System.out.println("Pet with ID: " + pet.getId() + " saved to DB");
        System.out.println("-----End-----");
        return pet;
    }

    public Pet findById(int id) throws PetNotFoundException{
        System.out.println("-----Find pet with ID: " + id + "-----");
        //for log purposes
        //entityManager.clear();
        Pet pet = entityManager.find(Pet.class, id);
        if(pet == null){
            throw new PetNotFoundException("Pet with ID: " + id + " not found");
        }
        //
        System.out.println("-----End-----");
        return pet;
    }

    public Pet updateAge(Pet pet, int age){
        System.out.println("-----Update pet age-----");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        pet.setAge(age);
        transaction.commit();
        System.out.println("-----End-----");
        return pet;
    }

    public void delete(Pet pet){
        System.out.println("-----Delete pet-----");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(pet);
        transaction.commit();
        System.out.println("-----End-----");
    }
}

package pl.jakubdrozdz.hibernate;


import pl.jakubdrozdz.hibernate.exception.PetNotFoundException;

public class LearningJpaHibernate {
    public static void main(String[] args) {
        PetRepository petRepository = new PetRepository();
        Pet pet = petRepository.createNewPet("Burek", 2);
        try {
            System.out.println(petRepository.findById(1));
        } catch (PetNotFoundException e) {
            e.printStackTrace();
        }
        pet = petRepository.updateAge(pet, 3);
        System.out.println(pet);
        petRepository.delete(pet);
        try {
            System.out.println(petRepository.findById(1));
        } catch (PetNotFoundException e) {
            e.printStackTrace();
        }
    }
}

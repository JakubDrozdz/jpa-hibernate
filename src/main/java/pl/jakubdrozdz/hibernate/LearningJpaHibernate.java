package pl.jakubdrozdz.hibernate;


public class LearningJpaHibernate {
    public static void main(String[] args) {
        PetRepository petRepository = new PetRepository();
        petRepository.createNewPet("Mamrotek", 2);
    }
}

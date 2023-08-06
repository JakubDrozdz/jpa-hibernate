package pl.jakubdrozdz.hibernate;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.jakubdrozdz.hibernate.appointment.Appointment;
import pl.jakubdrozdz.hibernate.appointment.AppointmentRepository;
import pl.jakubdrozdz.hibernate.appointment.exception.AppointmentNotFoundException;
import pl.jakubdrozdz.hibernate.pet.exception.PetNotFoundException;
import pl.jakubdrozdz.hibernate.pet.Pet;
import pl.jakubdrozdz.hibernate.pet.PetRepository;

public class LearningJpaHibernate {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2_db");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        PetRepository petRepository = new PetRepository(entityManager);
        AppointmentRepository appointmentRepository = new AppointmentRepository(entityManager);
        Pet pet = petRepository.createNewPet("Burek", 2);
        try {
            System.out.println(petRepository.findById(1));
        } catch (PetNotFoundException e) {
            e.printStackTrace();
        }
        Appointment appointment = appointmentRepository.createAppointment(pet);
        try {
            System.out.println(appointmentRepository.findById(1));
        } catch (AppointmentNotFoundException e) {
            e.printStackTrace();
        }
        pet = petRepository.updateAge(pet, 3);
        try {
            System.out.println(appointmentRepository.findById(1));
        } catch (AppointmentNotFoundException e) {
            e.printStackTrace();
        }
        /*System.out.println(pet);
        petRepository.delete(pet);
        try {
            System.out.println(petRepository.findById(1));
        } catch (PetNotFoundException e) {
            e.printStackTrace();
        }*/
    }
}

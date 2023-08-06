package pl.jakubdrozdz.hibernate;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.jakubdrozdz.hibernate.Vet.Vet;
import pl.jakubdrozdz.hibernate.Vet.VetRepository;
import pl.jakubdrozdz.hibernate.appointment.Appointment;
import pl.jakubdrozdz.hibernate.appointment.AppointmentRepository;
import pl.jakubdrozdz.hibernate.appointment.exception.AppointmentNotFoundException;
import pl.jakubdrozdz.hibernate.pet.exception.PetNotFoundException;
import pl.jakubdrozdz.hibernate.pet.Pet;
import pl.jakubdrozdz.hibernate.pet.PetRepository;

import java.util.List;

public class LearningJpaHibernate {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2_db");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        PetRepository petRepository = new PetRepository(entityManager);
        AppointmentRepository appointmentRepository = new AppointmentRepository(entityManager);
        VetRepository vetRepository = new VetRepository(entityManager);
        Vet petsVet = vetRepository.createVet("Doe", "pets");
        Pet burek = petRepository.createNewPet("Burek", 2);
        Pet mamrotek = petRepository.createNewPet("Mamrotek", 4);
        try {
            System.out.println(petRepository.findById(1));
        } catch (PetNotFoundException e) {
            e.printStackTrace();
        }
        Appointment burekAppointment = appointmentRepository.createAppointment(burek);
        try {
            System.out.println(appointmentRepository.findById(1));
        } catch (AppointmentNotFoundException e) {
            e.printStackTrace();
        }
        burek = petRepository.updateAge(burek, 3);
        try {
            System.out.println(appointmentRepository.findById(1));
        } catch (AppointmentNotFoundException e) {
            e.printStackTrace();
        }
        Appointment mamrotrekAppointment = appointmentRepository.createAppointment(mamrotek);
        petsVet = vetRepository.addAppointments(petsVet, List.of(burekAppointment, mamrotrekAppointment));
        System.out.println(petsVet);
        /*System.out.println(pet);
        petRepository.delete(pet);
        try {
            System.out.println(petRepository.findById(1));
        } catch (PetNotFoundException e) {
            e.printStackTrace();
        }*/
    }
}

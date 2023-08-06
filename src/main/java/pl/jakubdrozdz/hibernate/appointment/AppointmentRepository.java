package pl.jakubdrozdz.hibernate.appointment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import pl.jakubdrozdz.hibernate.appointment.exception.AppointmentNotFoundException;
import pl.jakubdrozdz.hibernate.pet.Pet;
import pl.jakubdrozdz.hibernate.pet.exception.PetNotFoundException;

public class AppointmentRepository {
    private EntityManager entityManager;
    public AppointmentRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Appointment createAppointment(Pet pet){
        System.out.println("-----New appointment creation-----");
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Appointment appointment = new Appointment(pet);
        entityManager.persist(appointment);
        System.out.println("Created new appointment with ID: " + appointment.getId() + " for pet: " + appointment.getPet());
        entityTransaction.commit();
        System.out.println("-----End-----");
        return appointment;
    }

    public Appointment findById(int id) throws AppointmentNotFoundException{
        System.out.println("-----Find appointment with ID: " + id + "-----");
        Appointment appointment = entityManager.find(Appointment.class, id);
        if(appointment == null){
            throw new AppointmentNotFoundException("Appointment with ID: " + id + " not found");
        }
        System.out.println("-----End-----");
        return appointment;
    }
}

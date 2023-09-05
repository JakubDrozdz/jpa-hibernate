package pl.jakubdrozdz.hibernate.appointment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import pl.jakubdrozdz.hibernate.appointment.exception.AppointmentNotFoundException;
import pl.jakubdrozdz.hibernate.pet.Pet;

import java.util.List;

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
        Query query = entityManager.createQuery("FROM Appointment WHERE id = :id");
        query.setParameter("id", id);
        Object queryResult = query.getSingleResult();
        if(!(queryResult instanceof Appointment)){
            throw new AppointmentNotFoundException("Appointment with ID: " + id + " not found");
        }
        System.out.println("-----End-----");
        return (Appointment) queryResult;
    }

    public List<Appointment> findAppointmentsByPet(Pet pet){
        Query query = entityManager.createQuery("FROM Appointment WHERE pet = :petId");
        query.setParameter("petId", pet);
        return query.getResultList();
    }
}

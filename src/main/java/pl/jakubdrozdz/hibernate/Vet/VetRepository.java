package pl.jakubdrozdz.hibernate.Vet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import pl.jakubdrozdz.hibernate.Vet.exception.VetNotFoundException;
import pl.jakubdrozdz.hibernate.appointment.Appointment;

import java.util.List;

public class VetRepository {
    private EntityManager entityManager;

    public VetRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Vet createVet(String name, String specialization){
        System.out.println("-----New vet creation-----");
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Vet vet = new Vet(name, specialization);
        entityManager.persist(vet);
        System.out.println("Created new vet with ID: " + vet.getId());
        entityTransaction.commit();
        System.out.println("-----End-----");
        return vet;
    }

    public Vet createVet(String name, String specialization, List<Appointment> appointments){
        System.out.println("-----New vet creation-----");
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Vet vet = new Vet(name, specialization, appointments);
        entityManager.persist(vet);
        System.out.println("Created new vet with ID: " + vet.getId());
        entityTransaction.commit();
        System.out.println("-----End-----");
        return vet;
    }

    public Vet findById(int id) throws VetNotFoundException {
        System.out.println("-----Find vet with ID: " + id + "-----");
        //for log purposes
        //entityManager.clear();
        Vet vet = entityManager.find(Vet.class, id);
        if(vet == null){
            throw new VetNotFoundException("Vet with ID: " + id + " not found");
        }
        //
        System.out.println("-----End-----");
        return vet;
    }

    public Vet addAppointments(Vet vet, List<Appointment> appointments){
        System.out.println("-----Creation new appointments for vet ID: " + vet.getId() + "-----");
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        vet.addAppointments(appointments);
        entityManager.persist(vet);
        System.out.println("Added appointments " + appointments + " for vet ID: " + vet.getId());
        entityTransaction.commit();
        System.out.println("-----End-----");
        return vet;
    }
}

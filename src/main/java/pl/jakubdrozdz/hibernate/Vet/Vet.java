package pl.jakubdrozdz.hibernate.Vet;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.jakubdrozdz.hibernate.appointment.Appointment;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Vet {
    @Id
    @SequenceGenerator(name = "vet_id", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="vet_id")
    private int id;
    private String name;
    private String specialization;
    @OneToMany
    List<Appointment> appointments;

    public Vet(String name, String specialization){
        this(name, specialization, new ArrayList<>());
    }
    public Vet(String name, String specialization, List<Appointment> appointments){
        this.name = name;
        this.specialization = specialization;
        this.appointments = appointments;
    }

    public void addAppointments(List<Appointment> appointments){
        this.appointments.addAll(appointments);
    }

    @Override
    public String toString() {
        return "Vet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}

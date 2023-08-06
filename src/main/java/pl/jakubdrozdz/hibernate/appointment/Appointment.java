package pl.jakubdrozdz.hibernate.appointment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.jakubdrozdz.hibernate.pet.Pet;

@NoArgsConstructor
@Entity
@Setter
@Getter
public class Appointment {
    @Id
    @SequenceGenerator(name = "appointment_id", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="appointment_id")
    private int id;

    @OneToOne
    private Pet pet;

    public Appointment(Pet pet){
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", pet=" + pet +
                '}';
    }
}

package pl.jakubdrozdz.hibernate.appointment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.jakubdrozdz.hibernate.pet.Pet;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static jakarta.persistence.ConstraintMode.NO_CONSTRAINT;

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

    @Id
    @ManyToOne
    private Pet pet;

    @Id
    private String appointmentDate;

    public Appointment(Pet pet){
        this.pet = pet;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.appointmentDate = dtf.format(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", pet=" + pet +
                '}';
    }
}

package pl.jakubdrozdz.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
public class Pet {
    @Id
    @SequenceGenerator(name = "pet_id", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="pet_id")
    private int id = -1;
    private String name;
    private int age;

}

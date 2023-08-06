package pl.jakubdrozdz.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Setter
@Getter
public class Pet {
    @Getter
    @Id
    @SequenceGenerator(name = "pet_id", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="pet_id")
    private int id = -1;
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

package co.uniquindio.store.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PhoneNumber implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(nullable = true)
    @ManyToOne
    private Person person;

    @JoinColumn(nullable = true)
    @ManyToOne
    private Shop shop;

    @Column(length = 10,nullable = false)
    @NotBlank
    @Size(max = 10, min = 10, message = "El número debe tener 10 digitos")
    private String number;

    public PhoneNumber(String number, Person person) {
        this.number = number;
        this.person = person;
    }
}

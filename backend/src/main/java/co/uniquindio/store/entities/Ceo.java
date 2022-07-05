package co.uniquindio.store.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Ceo extends Person implements Serializable {

    public Ceo(String cedula, String name, String lastname, LocalDate birthday, @Email String email,
               String password, City city, List<PhoneNumber> phoneNumbers) {
        super(cedula, name, lastname, birthday, email, password, city, phoneNumbers);
    }
}

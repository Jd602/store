package co.uniquindio.store.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Manager extends Person implements Serializable {

    public Manager(String cedula, String name, String lastname, @Email String email,
                    String password, City city, List<PhoneNumber> phoneNumbers) {
        super(cedula, name, lastname, email, password, city, phoneNumbers);
    }
}

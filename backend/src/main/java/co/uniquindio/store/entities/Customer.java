package co.uniquindio.store.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer extends Person implements Serializable {

    @Column(length = 100, nullable = false)
    @Size(max = 100, message = "La dirección debe tener máximo 100 caracteres")
    @NotBlank(message = "Debe ingresar la dirección")
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoicesList;

    public Customer(String cedula, String name, String lastname, LocalDate birthday, @Email String email,
                     String password, City city, List<PhoneNumber> phoneNumbers, String address) {
        super(cedula, name, lastname, birthday, email, password, city, phoneNumbers);
        this.address = address;
    }
}

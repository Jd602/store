package co.uniquindio.store.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
public class Employee extends Person implements Serializable {

    private String code;
    private LocalDate start;
    private LocalDate end;
    private StatusJob status;

    @ManyToOne
    private Shop shop;

    @Column(length = 100, nullable = false)
    @Size(max = 100, message = "La dirección debe tener máximo 100 caracteres")
    @NotBlank(message = "Debe ingresar la dirección")
    private String address;

    @OneToMany(mappedBy = "cashier")
    private List<Invoice> invoicesList;

    public Employee(String cedula, String name, String lastname, LocalDate birthday, @Email String email,
                    String password, City city, List<PhoneNumber> phoneNumbers, String code, LocalDate start, LocalDate end, StatusJob status, Shop shop, String address) {
        super(cedula, name, lastname, birthday, email, password, city, phoneNumbers);
        this.code = code;
        this.start = start;
        this.end = end;
        this.status = status;
        this.shop = shop;
        this.address = address;
    }
}

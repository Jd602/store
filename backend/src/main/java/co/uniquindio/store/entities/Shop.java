package co.uniquindio.store.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Shop implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(length = 40, nullable = false)
    @Size(max = 40, message = "El nombre debe tener m�ximo 40 caracteres")
    @NotBlank(message = "Debe de escribir el nombre de la tienda")
    private String name;

    @Column(length = 100, nullable = false)
    @Size(max = 100, message = "La dirección debe tener máximo 100 caracteres")
    @NotBlank(message = "Debe ingresar la dirección")
    private String address;

    @JoinColumn(nullable = false)
    @ManyToOne
    private City city;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Manager manager;

    @OneToMany(mappedBy = "shop")
    private List<PhoneNumber> phoneNumbers;

    @OneToMany(mappedBy = "shop")
    private List<Employee> employees;

    @ManyToMany
    private List<Product> productsList;

    @OneToMany(mappedBy = "shop")
    private List<Invoice> invoicesList;
}

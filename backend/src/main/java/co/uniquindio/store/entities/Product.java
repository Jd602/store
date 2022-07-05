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
public class Product implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(nullable = false)
    @NotBlank(message = "Por favor defina el tipo del producto")
    private ProductType productType;//shirt, pants, shoes...

    @Column(length = 60, nullable = false)
    @Size(max = 60, message = "El nombre del producto no puede tener mas de 60 caracteres")
    @NotBlank(message = "El comentario no puede estar vacio")
    private String name;


    private int quantity;
    private float price;
    private String target;//men,women...
    private String brand;//adidas,nike...
    private String description;

    @ManyToMany(mappedBy = "productsList")
    private List<Shop> shopsList;

    @ManyToMany
    private List<Invoice> invoicesList;

}

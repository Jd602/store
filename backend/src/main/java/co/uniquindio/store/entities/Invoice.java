package co.uniquindio.store.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Invoice implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private LocalDate date;

    private float totalAmount;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Shop shop;

    @ManyToOne
    private Employee cashier;

    @ManyToMany(mappedBy = "invoicesList")
    private List<Product> productList;


}

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
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11, unique = true)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    @Size(max = 50, message = "El nombre del departamento no puede tener mas de 50 caracteres")
    @NotBlank(message = "El nombre del departamento no puede estar vacio")
    private String name;

    @OneToMany(mappedBy = "departamento")
    private List<City> cities;
}

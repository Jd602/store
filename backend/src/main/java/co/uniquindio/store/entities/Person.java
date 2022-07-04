package co.uniquindio.store.entities;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 11)
    @Size(max = 11, message = "El número de documento debe tener 11 dígitos")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @NotBlank(message = "Debe de escribir su cedula")
    private String cedula;

    @Column(length = 40, nullable = false)
    @Size(max = 40, message = "El nombre debe tener m�ximo 40 caracteres")
    @NotBlank(message = "Debe de escribir su nombre")
    private String name;

    @Column(length = 40, nullable = false)
    @Size(max = 40, message = "El apellido debe tener m�ximo 40 caracteres")
    @NotBlank(message = "Debe de escribir su apellido")
    private String lastname;

    @Email(message = "El correo electrónico no es válido")
    @Column(length = 125, nullable = false, unique = true)
    @Size(max = 125, message = "El correo electrónico debe tener máximo 125 caracteres")
    @NotBlank(message = "Debe de escribir su correo electrónico")
    private String email;

    @Column(length = 50, nullable = false)
    @Size(max = 50, message = "El password debe tener máximo 50 caracteres")
    @NotBlank(message = "Debe de escribir su password")
    private String password;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "person")
    @ToString.Exclude
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PhoneNumber> phoneNumbers ;



}

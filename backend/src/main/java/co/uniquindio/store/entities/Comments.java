package co.uniquindio.store.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11, unique = true)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 255, nullable = false)
    @Size(max = 255, message = "El comentario no puede tener mas de 500 caracteres")
    @NotBlank(message = "El comentario no puede estar vacio")
    private String comment;

    @Column(nullable = false)
    @NotBlank(message = "Por favor defina el tipo de su comentario")
    private TypeComment typeComment;

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    @NotBlank(message = "Por favor defina el tipo de su comentario")
    private int rating;

    @FutureOrPresent(message = "La fecha debe ser mayor o igual a la actual")
    @Column(nullable = false)
    private LocalDateTime commentDate;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Shop shop;


}

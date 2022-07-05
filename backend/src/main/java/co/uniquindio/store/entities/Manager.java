package co.uniquindio.store.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Manager extends Person implements Serializable {

    @OneToMany(mappedBy = "manager")
    private List<Shop> shopList;
}

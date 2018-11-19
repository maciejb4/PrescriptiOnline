package pl.coderslab.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor //tworzy bezargumentowy konstruktor
@AllArgsConstructor //tworzy konstruktor ze wszystkimi argumentami (oprocz id)
@Entity
public class Prescription extends BaseEntity {

    private String drugName;
    private Integer drugQuantity;
    private String drugDose;
    private boolean filledIn;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Drug> drugs;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}

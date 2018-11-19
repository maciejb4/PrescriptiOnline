package pl.coderslab.demo.domain;


import lombok.*;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Getter
@Setter
@NoArgsConstructor //tworzy bezargumentowy konstruktor
@AllArgsConstructor //tworzy konstruktor ze wszystkimi argumentami (oprocz id)
@ToString //tworzy metode to String
public class User extends BaseEntity{


    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int enabled;
    private String pesel;
    private Date dateOfBirth;
    private String address;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Prescription> prescriptions;


    public String getDateOfBirthString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        return formatter.format(dateOfBirth);
    }
}

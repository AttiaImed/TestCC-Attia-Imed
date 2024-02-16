package esprit.tn.testccattiaimed.Entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idMagasin;
    String nomMagasin;
    String adresseMagasin;
    String contactMaMagasin;
    @OneToOne(mappedBy = "magasinDirecteur",cascade  = CascadeType.ALL)
    Personnel directeur;
    @OneToMany(mappedBy = "magasinCaissier",cascade = CascadeType.ALL)
    Set<Personnel> caissier;
    @ManyToMany(mappedBy = "magasins",cascade = CascadeType.ALL)
    Set<Client> Clients;
}

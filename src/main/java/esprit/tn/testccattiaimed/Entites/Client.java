package esprit.tn.testccattiaimed.Entites;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idClient;
    String nomClient;
    String prenomClient;
    String adresseClient;
    @Column(unique = true)
    long cin;
    @OneToOne
    CarteFid carteFid;
    @ManyToMany
    Set<Magasin> magasins;
}

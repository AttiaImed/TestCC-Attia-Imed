package esprit.tn.testccattiaimed.Entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idPersonnel;
    String nomPersonnel;
    String prenomPersonnel;
    LocalDate dateNaissance;
    @Enumerated(EnumType.STRING)
    TypePersonnel typePersonnel;
    @OneToOne
    Magasin magasinDirecteur;
    @ManyToOne
    Magasin magasinCaissier;
}

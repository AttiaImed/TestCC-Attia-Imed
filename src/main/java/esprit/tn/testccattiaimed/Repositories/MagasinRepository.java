package esprit.tn.testccattiaimed.Repositories;

import esprit.tn.testccattiaimed.Entites.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagasinRepository extends JpaRepository<Magasin, Integer> {
    Magasin findByNomMagasin(String nom);
}

package esprit.tn.testccattiaimed.Repositories;

import esprit.tn.testccattiaimed.Entites.CarteFid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteFidRepository extends JpaRepository<CarteFid, Integer> {
    CarteFid findByNumeroCarte(long numCarte);
}

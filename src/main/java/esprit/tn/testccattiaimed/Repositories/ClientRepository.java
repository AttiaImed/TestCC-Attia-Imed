package esprit.tn.testccattiaimed.Repositories;

import esprit.tn.testccattiaimed.Entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByCin(long cin);
}

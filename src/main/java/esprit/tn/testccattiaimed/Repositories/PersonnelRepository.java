package esprit.tn.testccattiaimed.Repositories;

import esprit.tn.testccattiaimed.Entites.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {
}

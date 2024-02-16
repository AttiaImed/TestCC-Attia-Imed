package esprit.tn.testccattiaimed.Services.ServiceImpl;

import esprit.tn.testccattiaimed.Entites.Client;
import esprit.tn.testccattiaimed.Entites.Magasin;
import esprit.tn.testccattiaimed.Repositories.MagasinRepository;
import esprit.tn.testccattiaimed.Services.MagasinService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Primary
@Service("XServiceImpl")
@AllArgsConstructor
@Slf4j
public class MagasinServiceImpl implements MagasinService {
    MagasinRepository  magasinRepository;
    @Override
    public Magasin ajouterMagasinEtPersonnel(Magasin magasin) {
        return magasinRepository.save(magasin);
    }
    // use spring scheduler to display a console message everyday at 8am
    @Scheduled(cron = "0 0 8 * * ?")
    public void totalSolde(){
        log.info("Console message at 8 AM");
        List<Magasin> listM = magasinRepository.findAll();
        //display all carte sum in the list of
        for (Magasin magasin : listM) {
            Set<Client> clients = magasin.getClients();
            double sumOfLoyaltyCards = 0.0;

            for (Client client : clients) {
                sumOfLoyaltyCards += client.getCarteFid().getSolde();
            }

            log.info("Magasin {} - Sum of Carte de Fidelite: {}", magasin.getNomMagasin(), sumOfLoyaltyCards);
        }
    }
}

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
@Service("MagasinServiceImpl")
@AllArgsConstructor
@Slf4j
public class MagasinServiceImpl implements MagasinService {
    MagasinRepository  magasinRepository;
    @Override
    public Magasin ajouterMagasinEtPersonnel(Magasin magasin) {
        return magasinRepository.save(magasin);
    }
    @Scheduled(cron = "0 0 8 * * *")
    public void totalSolde(){
        log.info("Console message at 8 AM");
        double somme = 0.0;
        List<Magasin> listM = magasinRepository.findAll();
        for (Magasin magasin : listM) {
            Set<Client> clients = magasin.getClients();
            for (Client client : clients) {
                somme += client.getCarteFid().getSolde();
            }
            log.info("Magasin " + magasin.getNomMagasin() + " - somme des carte de fidelite: " + somme);
            somme=0.0;
        }
    }
}

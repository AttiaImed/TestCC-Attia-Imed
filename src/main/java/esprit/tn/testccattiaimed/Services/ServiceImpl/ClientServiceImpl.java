package esprit.tn.testccattiaimed.Services.ServiceImpl;

import esprit.tn.testccattiaimed.Entites.Client;
import esprit.tn.testccattiaimed.Entites.Magasin;
import esprit.tn.testccattiaimed.Repositories.ClientRepository;
import esprit.tn.testccattiaimed.Repositories.MagasinRepository;
import esprit.tn.testccattiaimed.Services.ClientService;

import java.util.ArrayList;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    ClientRepository clientRepository;
    MagasinRepository magasinRepository;
    @Override
    public Client ajouterClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public void affecterClientAMagasin(int idClient, int idMagasin) {
        Magasin m = magasinRepository.findById(idMagasin).get();
        Client c = clientRepository.findById(idClient).get();
        c.getMagasins().add(m);
        clientRepository.save(c);
    }

    @Override
    public List<Client> afficherClients(String nomMagasin) {
        Magasin m = magasinRepository.findByNomMagasin(nomMagasin);
        List<Client> list = new ArrayList<>(m.getClients());
        return list;
    }

}

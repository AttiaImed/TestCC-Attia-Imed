package esprit.tn.testccattiaimed.Services;

import esprit.tn.testccattiaimed.Entites.Client;

import java.util.List;

public interface ClientService {
    Client ajouterClient(Client c);
    void affecterClientAMagasin(int idClient,int idMagasin);
    List<Client> afficherClients(String nomMagasin);

}

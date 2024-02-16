package esprit.tn.testccattiaimed.Services;

import esprit.tn.testccattiaimed.Entites.CarteFid;

public interface CarteFidService {
    void ajouterCarteEtAffecterClient(CarteFid cartefid, long cin);
    long effecteurOperation(String typeOperation,long numCarte, int montant);

}

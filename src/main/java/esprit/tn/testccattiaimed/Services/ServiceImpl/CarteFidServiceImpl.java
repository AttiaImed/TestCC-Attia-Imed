package esprit.tn.testccattiaimed.Services.ServiceImpl;

import esprit.tn.testccattiaimed.Entites.CarteFid;
import esprit.tn.testccattiaimed.Entites.Client;
import esprit.tn.testccattiaimed.Repositories.CarteFidRepository;
import esprit.tn.testccattiaimed.Repositories.ClientRepository;
import esprit.tn.testccattiaimed.Services.CarteFidService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("CarteFidServiceImpl")
@AllArgsConstructor
@Slf4j
public class CarteFidServiceImpl implements CarteFidService {
    CarteFidRepository carteFidRepository;
    ClientRepository clientRepository;
    @Override
    public void ajouterCarteEtAffecterClient(CarteFid cartefid, long cin) {
        CarteFid cf = carteFidRepository.save(cartefid);
        Client c = clientRepository.findByCin(cin);
        c.setCarteFid(cf);
        clientRepository.save(c);

    }

    @Override
    public long effecteurOperation(String typeOperation, long numCarte, int montant) {
        CarteFid carteFid = carteFidRepository.findByNumeroCarte(numCarte);

        if (carteFid == null) {
            return -1;
        }

        long ancienSolde = carteFid.getSolde();
        long nMontant;
        if ("+".equals(typeOperation)) {


            nMontant = ancienSolde + montant;
        } else if ("-".equals(typeOperation)) {

            nMontant = ancienSolde - montant;
        } else {

            return -1;
        }

        carteFid.setSolde(nMontant);

        carteFidRepository.save(carteFid);

        return nMontant;
    }

}

package esprit.tn.testccattiaimed.Controller;

import esprit.tn.testccattiaimed.Entites.CarteFid;
import esprit.tn.testccattiaimed.Entites.Client;
import esprit.tn.testccattiaimed.Services.CarteFidService;
import esprit.tn.testccattiaimed.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carte")
public class CarteController {
    //    void ajouterCarteEtAffecterClient(CarteFid cartefid, long cin);
    //    long effecteurOperation(String typeOperation,long numCarte, int montant);

    @Autowired
    CarteFidService carteFidService;

    @PostMapping(path="/{cin}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ajouterObject(@PathVariable long cin,@RequestBody CarteFid cartefid){
        carteFidService.ajouterCarteEtAffecterClient(cartefid,cin);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

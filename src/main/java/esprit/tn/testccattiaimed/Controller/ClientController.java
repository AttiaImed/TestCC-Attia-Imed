package esprit.tn.testccattiaimed.Controller;

import esprit.tn.testccattiaimed.Entites.Client;
import esprit.tn.testccattiaimed.Entites.Magasin;
import esprit.tn.testccattiaimed.Repositories.ClientRepository;
import esprit.tn.testccattiaimed.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    // Client ajouterClient(Client c);
    //    void affecterClientAMagasin(int idClient,int idMagasin);
    //    List<Client> afficherClients(String nomMagasin);
    @Autowired
    ClientService clientService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> ajouterObject(@RequestBody Client o){
        Client addedObject = clientService.ajouterClient(o);
        return new ResponseEntity<Client>(addedObject , HttpStatus.CREATED);
    }
    @PutMapping(path="/{idClient}/{idMagasin}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ajouterObject(@PathVariable int idClient,@PathVariable int idMagasin){
        clientService.affecterClientAMagasin(idClient,idMagasin);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(path = "/{nomMagasin}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getObject(@PathVariable String nomMagasin){
        List<Client> listClient= clientService.afficherClients(nomMagasin);
        return new ResponseEntity<List<Client>>(listClient, HttpStatus.OK);
    }

}

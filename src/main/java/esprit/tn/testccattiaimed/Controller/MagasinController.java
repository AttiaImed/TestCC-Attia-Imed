package esprit.tn.testccattiaimed.Controller;

import esprit.tn.testccattiaimed.Entites.Magasin;
import esprit.tn.testccattiaimed.Services.MagasinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/magasin")
public class MagasinController {


    @Autowired
    MagasinService magasinService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Magasin> ajouterObject(@RequestBody Magasin o){

        Magasin addedObject = magasinService.ajouterMagasinEtPersonnel(o);

        return new ResponseEntity<Magasin>(addedObject , HttpStatus.CREATED);

    }
}

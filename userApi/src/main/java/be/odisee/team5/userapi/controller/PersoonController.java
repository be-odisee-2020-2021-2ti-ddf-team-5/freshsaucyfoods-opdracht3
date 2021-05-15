package be.odisee.team5.userapi.controller;

import be.odisee.team5.userapi.domain.Persoon;
import be.odisee.team5.userapi.service.PersoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8888", maxAge = 3600, allowCredentials = "true")
public class PersoonController {

    @Autowired
    PersoonService persoonService;

    @RequestMapping (path = "deletePersoon/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        persoonService.deletePersoon(id);
    }

    @RequestMapping (path = "persoon/{id}", method = RequestMethod.GET)
    Persoon persoon (@PathVariable("id") Integer id){
        return persoonService.getPersoonDetailsById(id);
    }

    @RequestMapping (path = "updatePersoon/{id}", method = RequestMethod.PUT)
    Persoon persoon (@RequestBody Persoon persoon){
        persoonService.processPersoon(persoon);
        return persoon;
    }

    @RequestMapping (path = "personen", method = RequestMethod.GET)
    List<Persoon> personen (){
        return  persoonService.getAllPersonen();
    }

    @RequestMapping (path = "createPersoon/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPersoon(@RequestBody Persoon persoon){
        persoonService.processPersoon(persoon);
    }

}


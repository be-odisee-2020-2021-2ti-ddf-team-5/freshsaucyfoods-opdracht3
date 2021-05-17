package be.odisee.team5.fsfopdracht2.controller;

import be.odisee.team5.fsfopdracht2.domain.Bestelling;
import be.odisee.team5.fsfopdracht2.formdata.BestellingData;
import be.odisee.team5.fsfopdracht2.service.FreshSaucyFoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8888", maxAge = 3600, allowCredentials = "true")
public class BestellingRestController {
    @Autowired
    protected FreshSaucyFoodsService freshSaucyFoodsService=null; // ready for dependency injection

    @RequestMapping("/bestelling.html")
    public String bestelling(){
        return "bestelling";
    }

    // REST GET ... breng de toestand van bestaande resources van de server naar de client (lijst van objecten)

    @RequestMapping(value={"/bestellingen"},method=RequestMethod.GET)
    public @ResponseBody
    List<Bestelling> getBestellingen(){

        List<Bestelling> bestellingen = freshSaucyFoodsService.getBestellingen();
        return bestellingen;
    }


    // REST PUT ... breng de toestand van bestaande resource van de client naar de server

    @RequestMapping(value={"/bestelling/{id}"},method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putPersoon(@PathVariable("id") Integer id, @RequestBody Bestelling bestelling){

        freshSaucyFoodsService.prepareEntryDataToEdit(id);
    }

    // REST DELETE ... hiermee wordt een resource verwijderd

    @RequestMapping(value={"/bestelling/{id}"},method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersoon(@PathVariable("id") Integer id){

        freshSaucyFoodsService.deleteBestelling(id);
    }

    // REST POST ... hiermee wordt een resource gecreeerd

    @RequestMapping(value={"/bestelling"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Bestelling createPersoon(@RequestBody BestellingData bestelling, HttpServletResponse response)
            throws BindException {


        freshSaucyFoodsService.processBesteling(bestelling);
        return bestelling;
    }
}

package be.odisee.team5.userapi.service;

import be.odisee.team5.userapi.dao.PersoonRepository;
import be.odisee.team5.userapi.domain.Persoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersoonServiceImpl implements PersoonService{

    @Autowired
    PersoonRepository persoonRepository;

    @Override
    public Persoon getPersoonDetailsById(int id) {
        Persoon persoon =  persoonRepository.findById(id);
        return persoon;
    }

    @Override
    public int processPersoon(Persoon persoon) {

        if(persoon.getPersoonId() == 0){
            //cretae new persoon
            persoonRepository.save(persoon);
        }
        else {
            //update an persoon
            Persoon persoon1 = persoonRepository.findById(persoon.getPersoonId());

            //mapping of persoon objecten
            persoon1.setEmailadress(persoon.getEmailadress());
            persoon1.setFamilienaam(persoon.getFamilienaam());
            persoon1.setPassword(persoon.getPassword());
            persoon1.setVoornaam(persoon.getVoornaam());
            persoon1.setRole(persoon.getRole());

            persoonRepository.save(persoon1);
        }
        return persoon.getPersoonId();
    }

    @Override
    public void deletePersoon(int id) {
        persoonRepository.deleteById(id);
    }

    @Override
    public List<Persoon> getAllPersonen() {
        return (List<Persoon>) persoonRepository.findAll();
    }
}

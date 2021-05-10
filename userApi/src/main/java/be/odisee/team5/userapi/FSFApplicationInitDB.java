package be.odisee.team5.userapi;


import be.odisee.team5.userapi.dao.PersoonRepository;
import be.odisee.team5.userapi.domain.Persoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class FSFApplicationInitDB implements CommandLineRunner {


    @Autowired
    PersoonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {


        Persoon p = new Persoon();
        p.setRole("ROLE_USER");
        p.setNaam("Jef");
        p.setFamilienaam("Lokers");
        p.setPassword("12345");
        p.setEmailadress("jef.lokers@hotmail.com");
        personRepository.save(p);

        Persoon p2 = new Persoon();
        p2.setRole("ROLE_ADMIN");
        p2.setNaam("Tom");
        p2.setFamilienaam("Berens");
        p2.setPassword("1");
        p2.setEmailadress("tom.berens@hotmail.com");
        personRepository.save(p2);
    }
}

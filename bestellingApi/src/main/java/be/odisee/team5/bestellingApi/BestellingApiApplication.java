package be.odisee.team5.fsfopdracht2;

import be.odisee.team5.userapi.dao.PersoonRepository;
import be.odisee.team5.userapi.domain.Persoon;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@EnableGlobalMethodSecurity
public class BestellingApiApplication {

    public static void main(String[] args) {
		SpringApplication.run(BestellingApiApplication.class, args);
	}

	/**
	 * Seeding of the database
	 * @param personRepository
	 * @return
	 */
	@Bean
	CommandLineRunner init(BestellingRepository bestellingRepository){
		Bestelling b = new Bestelling();
		b.setTitel("Eerste bestelling");
		b.setAantalLiterBesteld(10);
		b.setDatumStartproductie(LocalDate.now());
		b.setVooruitgang("In Productie");
		b.setVoorafAfgesprokenEindDatum(LocalDate.now().plusMonths(1));

		Bestelling b2 = new Bestelling();
		b.setTitel("Tweede bestelling");
		b.setAantalLiterBesteld(50);
		b.setDatumStartproductie(LocalDate.now());
		b.setVooruitgang("In Productie");
		b.setVoorafAfgesprokenEindDatum(LocalDate.now().plusMonths(2));


		return (evt) -> {bestellingRepository.save(b);};
	}

}

package be.odisee.team5.userapi;

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
public class UserApiApplication {

    public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	/**
	 * Seeding of the database
	 * @param personRepository
	 * @return
	 */
	@Bean
	CommandLineRunner init(PersoonRepository personRepository){
		Persoon p = new Persoon();
		p.setRole("ROLE_USER");
		p.setNaam("Jef");
		p.setFamilienaam("Lokers");
		p.setPassword("12345");
		p.setEmailadress("jef.lokers@hotmail.com");


		Persoon p2 = new Persoon();
		p2.setRole("ROLE_ADMIN");
		p2.setNaam("Tom");
		p2.setFamilienaam("Berens");
		p2.setPassword("1");
		p2.setEmailadress("tom.berens@hotmail.com");

		return (evt) -> {personRepository.save(p);personRepository.save(p2);};
	}

}

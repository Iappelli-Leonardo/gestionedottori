package it.prova.dottore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.prova.dottore.model.Dottore;
import it.prova.dottore.service.DoottoreService.DottoreService;

@SpringBootApplication
public class DottoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DottoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDottori(DottoreService dottoreService) {
		return (args) -> {

			// inizializzo il Db
			dottoreService.save(new Dottore("peppe", "rossi", "codes", true, false));
			dottoreService.save(new Dottore("franco", "verdi", "dsagse3", true, false));
			dottoreService.save(new Dottore("arnaldo", "bianchi", "dafg3", true, false));
			dottoreService.save(new Dottore("geppetto", "neri", "sdfs38", true, false));
			dottoreService.save(new Dottore("lorenzo", "baldi", "afgdfggg3", true, false));
			dottoreService.save(new Dottore("vincenzo", "pipitone", "fdaagf3", true, false));
			dottoreService.save(new Dottore("gabriele", "gabrieleGn", "dafgq4", true, false));
			dottoreService.save(new Dottore("leonardo", "iapp", "fadg34", true, false));
			
			// verifico inserimento
			System.out.println("Elenco Dottori");
			dottoreService.listAll().forEach(dottItem -> {
				System.out.println(dottItem);
			});

			
		};
	}

}

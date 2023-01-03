package co.com.neoris.timetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Clase principal encargada de hacer el precargado de los componentes del servicio
 */
@SpringBootApplication
@EnableJpaRepositories
public class TimetrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimetrackerApplication.class, args);
	}

}

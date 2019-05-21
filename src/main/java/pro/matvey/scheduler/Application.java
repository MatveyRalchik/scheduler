package pro.matvey.scheduler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(EventRepository repository) {
		return args -> {
			repository.save(new Event("event 1", new Date(), new Date()));
			repository.save(new Event("event 2", new Date(), new Date()));
		};
	}

}

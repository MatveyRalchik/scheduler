package pro.matvey.scheduler;

//https://spring.io/guides/gs/validating-form-input/
//https://spring.io/guides/gs/handling-form-submission/

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pro.matvey.scheduler.event.Event;
import pro.matvey.scheduler.event.EventRepository;

import java.time.Duration;
import java.time.Instant;

@SpringBootApplication
public class Application {
    @Value("${user.home}")
    String s;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    CommandLineRunner initDatabase(EventRepository repository) {
//        System.out.println(s);
//        Instant now = Instant.now();
//        return args -> {
//            repository.save(new Event("event 1", now, now.plus(Duration.ofHours(1))));
//            repository.save(new Event("event 2", now.plus(Duration.ofHours(2)), now.plus(Duration.ofHours(3))));
//            repository.save(new Event("event 3", now.plus(Duration.ofHours(4)), now.plus(Duration.ofHours(5))));
//            repository.save(new Event("event 4", now.plus(Duration.ofHours(6)), now.plus(Duration.ofHours(7))));
//        };
//    }

}

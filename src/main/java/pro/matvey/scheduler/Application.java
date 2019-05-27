package pro.matvey.scheduler;

//https://spring.io/guides/gs/validating-form-input/
//https://spring.io/guides/gs/handling-form-submission/
//https://www.logicbig.com/tutorials/spring-framework/spring-boot/mvc-form-input-validation.html

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pro.matvey.scheduler.event.EventRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {
    //@Value("${user.home}") String s;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(EventRepository repository) {
        LocalDateTime dateTime = LocalDateTime.now();
        return args -> {
//            repository.save(new Event("event 1", dateTime, dateTime.plusHours(1)));
//            repository.save(new Event("event 2", dateTime.plusHours(2), dateTime.plusHours(3)));
//            repository.save(new Event("event 3", dateTime.plusHours(4), dateTime.plusHours(5)));
        };
    }

}

package pro.matvey.scheduler.event;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime start;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime end;

    @AssertTrue(message = "End date must be after start date")
    public boolean isDateTimeValid() {
        return end.isAfter(start);
    }

}

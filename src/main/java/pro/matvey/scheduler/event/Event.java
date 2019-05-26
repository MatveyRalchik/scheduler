package pro.matvey.scheduler.event;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String name;

    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
    private Date start;

    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
    private Date end;

    protected Event() {
    }

    public Event(String name, Date start, Date end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }
    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

}

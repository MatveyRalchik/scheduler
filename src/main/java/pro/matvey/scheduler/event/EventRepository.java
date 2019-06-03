package pro.matvey.scheduler.event;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findAll();

    @Query("select e from Event e where" +
            " e.start between :start and :end" +
            " or e.end between :start and :end" +
            " or e.start < :start and e.end > :end")
    public List<Event> findReserved(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

}

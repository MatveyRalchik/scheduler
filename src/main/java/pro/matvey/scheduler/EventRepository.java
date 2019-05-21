package pro.matvey.scheduler;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findAll();

}

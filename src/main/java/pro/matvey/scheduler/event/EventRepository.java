package pro.matvey.scheduler.event;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Override
    @Cacheable("events")
    Optional<Event> findById(Long id);

    @Override
    @CachePut(cacheNames = "events", key = "#event.id")
    Event save(Event event);

    @Override
    @CacheEvict("events")
    void deleteById(Long id);

    @Query("select e from Event e where" +
            " e.start between :start and :end" +
            " or e.end between :start and :end" +
            " or e.start < :start and e.end > :end")
    public List<Event> findReserved(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

}

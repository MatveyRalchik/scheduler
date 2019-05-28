package pro.matvey.scheduler.event;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> events() {
        return eventRepository.findAll();
    }

    public Event get(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("event " + id + "not found"));
    }

    public Event save(Event event) {

        return eventRepository.save(event);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

}

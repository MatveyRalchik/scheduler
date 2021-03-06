package pro.matvey.scheduler.event;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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

    public List<Event> events(Event filter) {
        return eventRepository.findAll(Example.of(filter));
    }

    public Event get(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("event " + id + "not found"));
    }

    public Event save(Event event, BindingResult bindingResult) {
        List<Event> events = eventRepository.findReserved(event.getStart(), event.getEnd());

        if (events.stream().filter(e -> !e.getId().equals(event.getId())).count() > 0) {
            bindingResult.rejectValue("start", "", "Requested date and time already reserved");
            bindingResult.rejectValue("end", "", "Requested date and time already reserved");
        }

        if (bindingResult.hasErrors())
            return null;
        else
            return eventRepository.save(event);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

}

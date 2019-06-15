package pro.matvey.scheduler.event;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Controller
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String getEvents(Model model) {
        model.addAttribute("events", eventService.events());
        return "event_list";
    }

    @GetMapping("/event")
    public String newEvent(Event event) {
        event.setName("Random name" + LocalDateTime.now().getSecond());
        event.setStart(LocalDateTime.now().truncatedTo(ChronoUnit.HOURS).plusHours(1));
        event.setEnd(LocalDateTime.now().truncatedTo(ChronoUnit.HOURS).plusHours(2));
        return "event";
    }

    @GetMapping("/event/{id}")
    public String getEvent(@PathVariable Long id, Model model) {
        model.addAttribute("event", eventService.get(id));
        return "event";
    }

    @PostMapping("/event")
    public String postEvent(
            @RequestParam Long id,
            @RequestParam String start,
            @RequestParam String end,
            @ModelAttribute("event") @Valid Event event,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            bindingResult.recordFieldValue("id", Long.class, id);
            bindingResult.recordFieldValue("start", LocalDateTime.class, start);
            bindingResult.recordFieldValue("end", LocalDateTime.class, end);
            return ("event");
        }

        eventService.save(event, bindingResult);
        if (bindingResult.hasErrors())
            return ("event");

        return "redirect:/";
    }

    @GetMapping("/event/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
        return "redirect:/";
    }

}

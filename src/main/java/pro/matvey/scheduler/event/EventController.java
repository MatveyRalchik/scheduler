package pro.matvey.scheduler.event;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/event/{id}")
    public String getEvent(@PathVariable Long id, Model model) {
        model.addAttribute("event", eventService.event(id));
        return "event";
    }

    @PostMapping("/event")
    public String postEvent(@ModelAttribute @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm") Event event) {
        eventService.save(event);
        return "event";
        //return "redirect:/";
    }

}

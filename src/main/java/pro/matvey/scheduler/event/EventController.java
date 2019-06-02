package pro.matvey.scheduler.event;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;


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
        System.out.println("log");
        event.setStart(LocalDateTime.now());
        event.setEnd(LocalDateTime.now());
        return "event";
    }

    @GetMapping("/event/{id}")
    public String getEvent(@PathVariable Long id, Model model) {
        model.addAttribute("event", eventService.event(id));
        return "event";
    }

    @PostMapping("/event")
    public String postEvent(
            //@PathVariable Long id,
            @ModelAttribute("event") @Valid Event event,
            BindingResult bindingResult,
            RedirectAttributes attr,
            HttpSession session
            //Model model
    ) {
        System.out.println(event);

        if (bindingResult.hasErrors()) {
            //return "redirect:/event/" + id;
            attr.addFlashAttribute("org.springframework.validation.BindingResult.event", bindingResult);
            attr.addFlashAttribute("event", event);
            return "event";

        }
        //event.setId(id);
        //System.out.println(event);
        eventService.save(event);
        return "redirect:/";
    }

    @GetMapping("/event/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
        return "redirect:/";
    }

}

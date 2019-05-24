package pro.matvey.scheduler.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;

//import javax.validation.Validator;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EventController {

    @Autowired
    EventRepository eventRepository;

    //@Autowired
    //Logger log;

    @Autowired
    Validator validator;

    @GetMapping("/")
    //public String scheduler(@PathVariable(name = "t") String t, @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    public String scheduler(Model model) {
        model.addAttribute("events", eventRepository.findAll());


        //log.info("request");
//        System.out.println(eventRepository.count());
//        model.addAllAttributes(eventRepository.findAll());
//        System.out.println(model.asMap().size());
//        model.asMap().forEach(
//                (S, O) -> System.out.println(S + " = " + O)
//        );
        return "scheduler";
    }

}

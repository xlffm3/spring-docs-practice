package practice.docs.spring.flash;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import practice.docs.spring.session.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FlashController {

    @PostMapping("/events/form/flash")
    public String eventId(@Validated @ModelAttribute Event event,
                          BindingResult bindingResult,
                          SessionStatus sessionStatus,
                          RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "form-id";
        }
        sessionStatus.setComplete();
        redirectAttributes.addFlashAttribute("newEvent", event);
        return "redirect:/flash";
    }

    @GetMapping("/flash")
    public String getList(Model model,
                          @ModelAttribute("newEvent") Event newEvent,
                          @SessionAttribute LocalDateTime visitTime) {
        System.out.println(visitTime);
        Event event = new Event();
        List<Event> eventList = new ArrayList<>();
        event.setName("spring");
        eventList.add(event);
        eventList.add(newEvent);
        //or Event newEvent = (Event) model.asMap().get("newEvent");
        model.addAttribute(eventList);
        return "list";
    }
}

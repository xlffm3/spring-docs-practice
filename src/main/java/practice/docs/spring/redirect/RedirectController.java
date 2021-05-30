package practice.docs.spring.redirect;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import practice.docs.spring.session.Event;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RedirectController {

    @PostMapping("/events/form/id")
    public String eventId(@Validated @ModelAttribute Event event, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "form-id";
        }
        redirectAttributes.addAttribute("name", event.getName());
        redirectAttributes.addAttribute("id", event.getId());
        //redirect시 일반 model에 담은 상태라면 /events/list?name=xx&id=yy
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getList(Model model, @RequestParam String name, @RequestParam Integer id) {
        Event event = new Event();
        List<Event> eventList = new ArrayList<>();
        event.setName("spring");
        eventList.add(event);
        model.addAttribute(eventList);
        return "list";
    }
}

package practice.docs.spring.session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"event", "book"})
public class SessionController {

    @GetMapping("/events/form")
    public String eventsForm(Model model, SessionStatus sessionStatus) {
        model.addAttribute("event", new Event());
        return "form";
    }

    @GetMapping("/another/session")
    public String sessionBinder(@SessionAttribute String session) {
        if (session != null) {
            return "ok";
        }
        return "no";
    }
}

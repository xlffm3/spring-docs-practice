package practice.docs.spring.model;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import practice.docs.spring.session.Event;

import java.util.Arrays;
import java.util.List;

@RestController
public class ModelTest {

    @ModelAttribute("categories")
    public List<String> categories() {
        return Arrays.asList("a", "b", "c");
    }

    @GetMapping("/test/view")
    @ModelAttribute
    public Event getEvent() {
        return new Event();
    }

    @GetMapping("/model/test")
    public String test(Model model) {
        List<String> categories = (List<String>) model.getAttribute("categories");
        return categories.get(0) + "" + categories.get(1) + "" + categories.get(2);
    }
}

package practice.docs.spring.advice;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AdviceController {

    @GetMapping("/animal")
    public String animalAdvice(@ModelAttribute @Valid Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "no";
        }
        return "ok";
    }
}

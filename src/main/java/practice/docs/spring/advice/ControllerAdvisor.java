package practice.docs.spring.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = AdviceController.class)
public class ControllerAdvisor {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
        webDataBinder.addCustomFormatter(new AnimalFormatter());
        webDataBinder.addValidators(new AnimalValidator());
    }
}

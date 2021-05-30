package practice.docs.spring.interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorController {

    @GetMapping("/interceptor")
    public String interceptor() {
        return "interceptor";
    }
}

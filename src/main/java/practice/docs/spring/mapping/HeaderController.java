package practice.docs.spring.mapping;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {

    @GetMapping(value = "/header", headers = HttpHeaders.AUTHORIZATION + "=111")
    public String handleMapping() {
        return "ok";
    }
}

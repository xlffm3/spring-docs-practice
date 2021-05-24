package practice.docs.spring.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsController {

    @CrossOrigin(origins = "http://localhost:18080")
    @GetMapping("/cors")
    public String cors() {
        System.out.println("method call!");
        return "cors ok";
    }
}

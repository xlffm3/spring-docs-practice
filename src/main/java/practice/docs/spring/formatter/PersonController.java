package practice.docs.spring.formatter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/person")
    public ResponseEntity<String> handlePerson(@RequestParam("name") Person person) {
        return ResponseEntity.ok(person.getName());
    }
}

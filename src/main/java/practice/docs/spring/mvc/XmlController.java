package practice.docs.spring.mvc;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmlController {

    @PostMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<User> user(@RequestBody User user) {
        System.out.println("jipark");
        System.out.println(user.getAge());
        System.out.println(user.getName());
        return ResponseEntity.ok(user);
    }
}

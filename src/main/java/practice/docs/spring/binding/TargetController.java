package practice.docs.spring.binding;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TargetController {

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Target.class, new TargetEditor());
    }

    @GetMapping("/target/{target}")
    public ResponseEntity<Target> handleTarget(@PathVariable Target target) {
        System.out.println("target log~~" + target.getMoney());
        return ResponseEntity.ok(target);
    }
}

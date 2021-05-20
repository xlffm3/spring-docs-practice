package practice.docs.spring.binding;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TargetConverterController {

    @GetMapping("/targetconverter/{target}")
    public ResponseEntity<Target> handleTarget(@PathVariable Target target) {
        return ResponseEntity.ok(target);
    }
}

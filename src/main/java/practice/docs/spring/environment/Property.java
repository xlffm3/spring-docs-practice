package practice.docs.spring.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Property {

    @Value("${test.property}")
    private String name;

    public String getName() {
        return name;
    }
}

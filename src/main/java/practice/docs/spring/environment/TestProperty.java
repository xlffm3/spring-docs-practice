package practice.docs.spring.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestProperty {

    @Value("${source.name}")
    private String name;

    public String getName() {
        return name;
    }
}

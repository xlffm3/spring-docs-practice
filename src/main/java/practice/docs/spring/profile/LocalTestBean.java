package practice.docs.spring.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LocalTestBean {

    @Value("${poo.name}")
    private String name;

    @Value("${poo.age}")
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

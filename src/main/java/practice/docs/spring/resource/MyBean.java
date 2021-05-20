package practice.docs.spring.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    private Resource template;

    public MyBean(@Value("${resource.location}") Resource template) {
        this.template = template;
    }

    public Resource getTemplate() {
        return template;
    }
}

package practice.docs.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import practice.docs.spring.environment.Property;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PropertyTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void property() {
        Environment environment = applicationContext.getEnvironment();
        Property property = applicationContext.getBean("property", Property.class);
        String name = environment.getProperty("test.property");

        assertThat(name).isEqualTo("kevin");
        assertThat(property.getName()).isEqualTo("kevin");
    }
}

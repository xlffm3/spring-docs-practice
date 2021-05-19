package practice.docs.spring.environment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application-test.properties")
public class TestPropertyConfig {

    @Bean
    public TestProperty testProperty() {
        return new TestProperty();
    }
}

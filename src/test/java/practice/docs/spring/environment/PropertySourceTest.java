package practice.docs.spring.environment;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import static org.assertj.core.api.Assertions.assertThat;

class PropertySourceTest {

    @Test
    void propertySource() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestPropertyConfig.class);
        Environment environment = applicationContext.getEnvironment();
        String invalidProperty = environment.getProperty("test.property");
        String validName = applicationContext.getBean("testProperty", TestProperty.class)
                .getName();
        String property = environment.getProperty("source.name");

        assertThat(invalidProperty).isNull();
        assertThat(validName).isEqualTo("woowacourse");
        assertThat(property).isEqualTo("woowacourse");
    }
}

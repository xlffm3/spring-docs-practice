package practice.docs.spring.config;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class XmlConfigAppTest {

    @Test
    void xmlConfig() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext.xml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        assertThat(beanDefinitionNames).contains("a1", "b1", "c1");
    }
}

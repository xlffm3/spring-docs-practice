package practice.docs.spring.config;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class ComponentScanAppTest {

    @Test
    void componentScan() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScanConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        assertThat(beanDefinitionNames).contains("a1", "b1", "c1")
                .doesNotContain("userService", "userRepository");
    }
}

package practice.docs.spring.environment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("main")
class ProfileTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void profile() {
        Environment environment = applicationContext.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        assertThat(activeProfiles).contains("main");
        assertThat(beanDefinitionNames).contains("bean1", "bean2").doesNotContain("bean3");
    }
}

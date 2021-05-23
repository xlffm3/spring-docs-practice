package practice.docs.spring.configure;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ConfigureTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void holoman() {
        HoloMan holoMan = applicationContext.getBean("holoMan", HoloMan.class);

        assertThat(holoMan.getName()).isEqualTo("kevin");
    }
}

package practice.docs.spring.profile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProfileTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void profileTest() {
        TestBean testBean = applicationContext.getBean("testBean", TestBean.class);
        LocalTestBean localTestBean = applicationContext.getBean("localTestBean", LocalTestBean.class);

        assertThat(testBean).isNotNull();
        assertThat(localTestBean.getName()).isEqualTo("kevin");
        assertThat(applicationContext.containsBean("prodBean")).isFalse();
    }
}

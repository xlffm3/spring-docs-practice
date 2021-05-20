package practice.docs.spring.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BeanScopeTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void scopeTest() {
        Single single = applicationContext.getBean("single", Single.class);

        assertThat(single.getProto()).isEqualTo(single.getProto());
        assertThat(single.getProxyProto()).isSameAs(single.getProxyProto());
    }
}

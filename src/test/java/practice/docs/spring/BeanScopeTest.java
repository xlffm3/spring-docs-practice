package practice.docs.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practice.docs.spring.bean.scope.Single;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BeanScopeTest {

    @Autowired
    private Single single;

    @Test
    void scopeTest() {
        assertThat(single.getProto()).isEqualTo(single.getProto());
        assertThat(single.getProxyProto()).isSameAs(single.getProxyProto());
    }
}

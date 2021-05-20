package practice.docs.spring.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProxyTest {

    @Autowired
    private EventService eventService;

    @Test
    void proxy() {
        assertThat(eventService).isInstanceOf(ProxyEventService.class);
    }

    @Test
    void proxy2() {
        ProxyFactory factory = new ProxyFactory(new SimpleEventService());
        factory.addInterface(EventService.class);
        factory.addAdvice(new AfterAdvice() {
        });
        EventService proxy = (EventService) factory.getProxy();

        assertThat(proxy).isNotInstanceOf(SimpleEventService.class);
    }
}

package practice.docs.spring.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest
class MyEventHandlerTest {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    void eventPublisher() {
        MyEvent myEvent = new MyEvent("abc", 13);
        applicationEventPublisher.publishEvent(myEvent);
    }
}

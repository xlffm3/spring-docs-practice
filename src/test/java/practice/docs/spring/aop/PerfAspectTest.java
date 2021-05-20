package practice.docs.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practice.docs.spring.proxy.SimpleEventService;

@SpringBootTest
class PerfAspectTest {

    @Autowired
    private SimpleEventService eventService;

    @Test
    void aop() {
        eventService.createEvent();
    }
}

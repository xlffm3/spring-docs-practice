package practice.docs.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler {

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public void handleEvent(MyEvent myEvent) {
        System.out.println("event accepted" + myEvent.getData());
    }
}

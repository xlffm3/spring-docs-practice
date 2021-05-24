package practice.docs.spring.event;

import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PortListener {

    @EventListener
    public void handleHttpCallback(ServletWebServerInitializedEvent event) {
        System.out.println("current port log");
        System.out.println(event.getApplicationContext().getWebServer().getPort());
    }
}

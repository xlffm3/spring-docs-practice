package practice.docs.spring.servlet;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class MyListener implements ServletContextListener {

    @EventListener
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context init");
    }

    @EventListener
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context destroyed");
    }
}

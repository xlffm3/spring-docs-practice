package practice.docs.spring.proxy;

import org.springframework.stereotype.Service;

@Service
public class SimpleEventService implements EventService {

    @Override
    public void createEvent() {
        System.out.println("hi");
    }

    @Override
    public void publishEvent() {
    }
}

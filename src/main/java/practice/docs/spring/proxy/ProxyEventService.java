package practice.docs.spring.proxy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ProxyEventService implements EventService {

    private final SimpleEventService simpleEventService;

    public ProxyEventService(SimpleEventService simpleEventService) {
        this.simpleEventService = simpleEventService;
    }

    @Override
    public void createEvent() {
        //시간 측정 로그 작업
        simpleEventService.createEvent();
        //시간 측정 로그 작업
    }

    @Override
    public void publishEvent() {
        //시간 측정 로그 작업
        simpleEventService.publishEvent();
        //시간 측정 로그 작업
    }
}

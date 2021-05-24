package practice.docs.spring.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LogComponent {
    private static final Logger logger = LoggerFactory.getLogger(LogComponent.class);

    @PostConstruct
    public void handle() {
        logger.info("post construct from log component");
    }

    public void printLog() {
        logger.error("findable");
    }
}

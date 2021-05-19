package practice.docs.spring.environment;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("main")
public class Bean1 {
}

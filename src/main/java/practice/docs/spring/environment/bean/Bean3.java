package practice.docs.spring.environment.bean;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class Bean3 {
}

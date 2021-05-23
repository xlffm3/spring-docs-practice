package practice.docs.spring.configure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HoloManProperties.class)
public class Config {

    @Bean
    public HoloMan holoMan(HoloManProperties holoManProperties) {
        return new HoloMan(holoManProperties.getName(), holoManProperties.getAge());
    }
}

package practice.docs.spring.resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/mobile/**") //dispatcher 패키지의 config로 인해 prefix가 static
                .addResourceLocations("classpath:/mobile")
                .setCachePeriod(50);
    }
}

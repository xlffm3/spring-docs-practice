package practice.docs.spring.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Hellointerceptor()).order(0).addPathPatterns("/interceptor");
        registry.addInterceptor(new GreetingInterceptor()).order(-1).addPathPatterns("/interceptor");
    }
}

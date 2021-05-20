package practice.docs.spring.binding;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import practice.docs.spring.binding.converter.TargetConverter;
import practice.docs.spring.binding.formatter.TargetFormatter;

@Configuration
public class BindingConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new TargetFormatter());
        registry.addConverter(new TargetConverter.StringToTargetConverter());
        registry.addConverter(new TargetConverter.TargetToStringConverter());
    }
}

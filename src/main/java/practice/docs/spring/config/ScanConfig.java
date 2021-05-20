package practice.docs.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "practice.docs.spring.bean.component")
@Configuration
public class ScanConfig {
}

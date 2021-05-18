package practice.docs.spring.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "practice.docs.spring.bean.component")
@Configuration
public class ScanConfig {
}

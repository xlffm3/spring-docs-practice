package practice.docs.spring;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import practice.docs.spring.event.ContextListener;

@EnableAdminServer
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplicationBuilder().sources(Application.class).build();
        springApplication.addListeners(new ContextListener());
        springApplication.setApplicationStartup(new BufferingApplicationStartup(2048));
        //springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
        //SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public ServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
//        return tomcat;
//    }
//
//    private Connector createStandardConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setPort(8443);
//        return connector;
//    }
}

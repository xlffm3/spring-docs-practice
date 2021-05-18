package practice.docs.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice.docs.spring.bean.TestBeanFactory;
import practice.docs.spring.bean.user.UserService;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestBeanFactory.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.printHello();

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames)
                .forEach(System.out::println);
        /*
        내가 등록한 Bean 이외에도 다음 Bean들이 정의되어 있다.
        org.springframework.context.annotation.internalConfigurationAnnotationProcessor
        org.springframework.context.annotation.internalAutowiredAnnotationProcessor
        org.springframework.context.annotation.internalCommonAnnotationProcessor
        org.springframework.context.event.internalEventListenerProcessor
        org.springframework.context.event.internalEventListenerFactory
         */

        Class<?> dataSource = applicationContext.getType("dataSource");
        System.out.println(dataSource); //DataSource 인스턴스의 실제 런타임 타입, SingleConnectionDataSource
    }
}

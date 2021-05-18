package practice.docs.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import practice.docs.spring.bean.user.UserService;

public class XmlConfigApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.printHello();
    }
}

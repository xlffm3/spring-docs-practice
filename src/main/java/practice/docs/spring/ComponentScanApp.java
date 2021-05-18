package practice.docs.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practice.docs.spring.bean.ScanConfig;
import practice.docs.spring.bean.component.A1;
import practice.docs.spring.bean.component.B1;
import practice.docs.spring.bean.component.C1;

public class ComponentScanApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScanConfig.class);
        A1 a1 = applicationContext.getBean("a1", A1.class);
        B1 b1 = applicationContext.getBean("b1", B1.class);
        C1 c1 = applicationContext.getBean("c1", C1.class);

        System.out.println(a1 != null);
        System.out.println(b1 != null);
        System.out.println(c1 != null);
    }
}

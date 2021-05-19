package practice.docs.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import practice.docs.spring.bean.TestBeanFactory;
import practice.docs.spring.bean.user.UserService;

import static org.assertj.core.api.Assertions.assertThat;

class AnnotationConfigAppTest {

    @Test
    void annotationConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestBeanFactory.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Class<?> dataSource = applicationContext.getType("dataSource");

        assertThat(beanDefinitionNames).contains("userService", "userRepository", "dataSource");
        assertThat(dataSource).isEqualTo(SingleConnectionDataSource.class);
        assertThat(userService).isNotNull();
    }
}

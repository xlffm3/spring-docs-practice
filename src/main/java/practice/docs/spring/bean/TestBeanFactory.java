package practice.docs.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import practice.docs.spring.bean.user.UserRepository;
import practice.docs.spring.bean.user.UserService;

import javax.sql.DataSource;

@Configuration
public class TestBeanFactory {

    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        return new SingleConnectionDataSource();
    }
}

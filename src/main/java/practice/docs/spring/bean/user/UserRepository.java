package practice.docs.spring.bean.user;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

public class UserRepository {

    private final DataSource dataSource;

    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    void postConstruct() {
        System.out.println("already autowired?" + (dataSource != null));
    }
}

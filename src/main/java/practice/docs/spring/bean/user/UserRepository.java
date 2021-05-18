package practice.docs.spring.bean.user;

import javax.sql.DataSource;

public class UserRepository {

    private final DataSource dataSource;

    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

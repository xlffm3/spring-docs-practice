package practice.docs.spring.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import practice.docs.spring.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
class BatchDaoTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private BatchDao batchDao;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        batchDao = new BatchDao(jdbcTemplate);
        jdbcTemplate.execute("create table if not exists car ( id bigint auto_increment not null, name varchar ( 255 ) not null, color varchar(255) not null, primary key ( id ))");
        cars = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            cars.add(new Car((long) i, "abcav", "adfkadf"));
        }
    }

    @DisplayName("Batch를 사용하지 않고 데이터를 삽입한다.")
    @Test
    void insert() {
        int returnValue = batchDao.insert(cars);
        List<Car> cars = batchDao.findAll();

        assertThat(returnValue).isEqualTo(10000);
        assertThat(cars).hasSize(10000);
    }

    @DisplayName("Batch를 사용하여 데이터를 삽입한다.")
    @Test
    void batchInsert() {
        int[] returnValue = batchDao.batchInsert(cars);

        List<Car> cars = batchDao.findAll();

        assertThat(returnValue).hasSize(10000);
        assertThat(cars).hasSize(10000);
    }

    @DisplayName("NamedJdbcTemplate을 사용한다.")
    @Test
    void batchInsertWithNamedJdbc() {
        int[] returnValue = batchDao.batchInsertWithNamedJdbc(cars);

        List<Car> cars = batchDao.findAll();

        assertThat(returnValue).hasSize(10000);
        assertThat(cars).hasSize(10000);
    }

    @DisplayName("오버라이딩된 batchUpdate 메서드를 사용한다.")
    @Test
    void batchInsertVariation() {
        int[] returnValue = batchDao.batchInsertVariation(cars);
        List<Car> cars = batchDao.findAll();

        assertThat(returnValue).hasSize(10000);
        assertThat(cars).hasSize(10000);
    }

    @DisplayName("멀티플 batchUpdate 메서드를 사용한다.")
    @Test
    void batchInsertMultiple() {
        int[][] returnValue = batchDao.batchInsertMultiple(cars);

        List<Car> cars = batchDao.findAll();

        assertThat(returnValue.length * returnValue[0].length).isEqualTo(10000);
        assertThat(cars).hasSize(10000);
    }
}

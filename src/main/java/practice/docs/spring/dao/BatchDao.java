package practice.docs.spring.dao;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import practice.docs.spring.domain.Car;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BatchDao {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BatchDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    public int insert(List<Car> cars) {
        String sql = "insert into car(name, color) values(?, ?)";
        int size = cars.size();
        int resultSize = 0;
        for (int i = 0; i < size; i++) {
            Car car = cars.get(i);
            resultSize += jdbcTemplate.update(sql, car.getName(), car.getColor());
        }
        return resultSize;
    }

    public int[] batchInsert(List<Car> cars) {
        String sql = "insert into car(name, color) values(?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Car car = cars.get(i);
                ps.setString(1, car.getName());
                ps.setString(2, car.getColor());
            }

            @Override
            public int getBatchSize() {
                return cars.size();
            }
        });
    }

    public int[] batchInsertVariation(List<Car> cars) {
        List<Object[]> batch = new ArrayList<>();
        for (Car car : cars) {
            Object[] values = new Object[]{car.getName(), car.getColor()};
            batch.add(values);
        }
        String sql = "insert into car(name, color) values(?,?)";
        return jdbcTemplate.batchUpdate(sql, batch);
    }


    public int[] batchInsertWithNamedJdbc(List<Car> cars) {
        String sql = "insert into car(name, color) values(:name, :color)";
        return namedParameterJdbcTemplate.batchUpdate(sql, SqlParameterSourceUtils.createBatch(cars));
    }

    public int[][] batchInsertMultiple(List<Car> cars) {
        String sql = "insert into car(name, color) values(?,?)";
        return jdbcTemplate.batchUpdate(sql, cars, 100, (ps, argument) -> {
            ps.setString(1, argument.getName());
            ps.setString(2, argument.getColor());
        });
    }

    public List<Car> findAll() {
        String sql = "select * from car";
        RowMapper<Car> rowMapper = ((rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            String color = rs.getString("color");
            return new Car(id, name, color);
        });
        return jdbcTemplate.query(sql, rowMapper);
    }
}

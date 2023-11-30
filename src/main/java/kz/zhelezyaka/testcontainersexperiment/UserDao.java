package kz.zhelezyaka.testcontainersexperiment;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDao {

   private final JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        return jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM users",
                (rs, rowNum) -> new User(rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")));
    }
}

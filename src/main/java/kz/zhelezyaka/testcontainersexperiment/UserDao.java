package kz.zhelezyaka.testcontainersexperiment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Getter
@Setter
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public List<User> findAllUsers() {
        return jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM users",
                (rs, rowNum) -> new User(rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")));
    }

    public Optional<User> findUserById(Long id) {
        String query = "SELECT id, first_name, last_name FROM users WHERE id = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    query,
                    new Object[]{id},
                    (rs, rowNum) -> new User(
                            rs.getLong("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name")
                    )
            ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}

package kz.zhelezyaka.experiment1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class JdbcAppTest {

    @Container
    public  PostgreSQLContainer<?> pgsql =
            new PostgreSQLContainer<>("postgres:latest");


    @Autowired
    public UserRepository userRepository;


    @Test
    void shouldToSaveUser() {
        var user = userRepository
                .save(new Users(null, "Aston", "Developer"));

        var all = userRepository.findAll();

        Assertions.assertTrue(all.iterator().hasNext(), () -> "there should be some date");
    }

    @Test
    void shouldToDeleteAllUsers() {
        userRepository.deleteAll();

        Assertions.assertTrue(!userRepository.findAll().iterator().hasNext(), () -> "there should be no date");
    }
}
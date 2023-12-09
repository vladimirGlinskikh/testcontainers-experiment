package kz.zhelezyaka.testcontainersexperiment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Container
    @ServiceConnection
    PostgreSQLContainer container =
            new PostgreSQLContainer<>("postgres:latest");


    @Test
    void shouldBeFiveUsersInDB() {
        List<User> users = userDao.findAllUsers();
        assertThat(users).hasSize(6);
    }
}
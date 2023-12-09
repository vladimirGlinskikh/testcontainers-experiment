package kz.zhelezyaka.experiment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
public class JdbcApp {
    public static void main(String[] args) {
        SpringApplication.run(JdbcApp.class, args);
    }
}

interface UserRepository extends CrudRepository<Users, Integer> {
}

record Users(@Id Integer id, String first_name, String last_name) {
}


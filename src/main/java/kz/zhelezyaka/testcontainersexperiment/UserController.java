package kz.zhelezyaka.testcontainersexperiment;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;

    @GetMapping("/")
    public List<User> users() {
        List<User> users = userDao.findAll();
        users.forEach(u -> log.info("Found a user: {}", u));
        return users;
    }
}

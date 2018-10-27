package nekr0s.project.card_users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("nekr0s.project.card_users.repositories")
public class CardUsersApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CardUsersApplication.class, args);
    }


}

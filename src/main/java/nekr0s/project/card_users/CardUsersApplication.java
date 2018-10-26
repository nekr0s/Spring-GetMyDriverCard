package nekr0s.project.card_users;

import nekr0s.project.card_users.models.Request;
import nekr0s.project.card_users.models.User;
import nekr0s.project.card_users.models.UserInfo;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardUsersApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CardUsersApplication.class, args);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Request.class)
                .addAnnotatedClass(UserInfo.class)
                .buildSessionFactory();
    }
}

package nekr0s.project.card_users.repositories.base;

import nekr0s.project.card_users.models.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    User getById(int id);

    void update(int id, User user);

    void create(User user);
}

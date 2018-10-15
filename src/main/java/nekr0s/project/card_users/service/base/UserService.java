package nekr0s.project.card_users.service.base;

import nekr0s.project.card_users.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    void create(User todo);

    void update (int id, User todo);

    void delete (int id);
}

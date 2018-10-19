package nekr0s.project.card_users.repositories.base;

import nekr0s.project.card_users.models.Request;
import nekr0s.project.card_users.models.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    List<Request> getAllUserRequests();

    User getById(int id);

    void update(int id, User todo);

    void delete(int id);

    void create(User todo);

    List<Request> getSpecificUserRequests(int userId);
}

package nekr0s.project.card_users.service;

import nekr0s.project.card_users.models.Request;
import nekr0s.project.card_users.models.User;
import nekr0s.project.card_users.repositories.base.UserRepository;
import nekr0s.project.card_users.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository todoRepository) {
        this.userRepository =todoRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }

    @Override
    public List<Request> getAllUserRequests() {
        return this.userRepository.getAllUserRequests();
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.getById(id);
    }

    @Override
    public void create(User todo) {
        userRepository.create(todo);
    }

    @Override
    public void update(int id, User todo) {
        userRepository.update(id, todo);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public List<Request> getSpecificUserRequest(int userId) {
        return userRepository.getSpecificUserRequests(userId);
    }
}

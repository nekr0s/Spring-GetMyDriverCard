package nekr0s.project.card_users.controllers;

import nekr0s.project.card_users.models.User;
import nekr0s.project.card_users.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserRestController {
    private UserService service;

    @Autowired
    public UserRestController(UserService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public void create(@RequestBody User user) {
        service.create(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody User user) {
        service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/{userId}/requests")
    public void getSpecificUserRequests(@PathVariable int userId) {
        service.getSpecificUserRequest(userId);
    }

    @GetMapping("/requests")
    public void getAllRequests() {
        service.getAllUserRequests();
    }
}

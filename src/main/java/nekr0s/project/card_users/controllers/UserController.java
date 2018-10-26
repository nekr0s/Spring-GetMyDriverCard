package nekr0s.project.card_users.controllers;

import nekr0s.project.card_users.repositories.base.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Validation in the back end

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List getUsers() {
        return userRepository.findAll();
    }
}

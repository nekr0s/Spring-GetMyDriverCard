package nekr0s.project.card_users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import nekr0s.project.card_users.exception.UserAlreadyExistAuthenticationException;
import nekr0s.project.card_users.models.User;
import nekr0s.project.card_users.service.CustomUserDetailsService;

// Validation in the back end

@RestController
@RequestMapping("api/users")
public class UserController {
    private final CustomUserDetailsService service;

    @Autowired
    public UserController(CustomUserDetailsService service) {
        this.service = service;
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public List getUsers() {
        return service.getAllUsers();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return service.getUserByUserId(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/me")
    public @ResponseBody
    User getCurrentUser(Principal principal) {
        return (User) service.loadUserByUsername(principal.getName());
    }

    @ResponseBody
    @PostMapping("/signup")
    public User registerUser(@RequestBody User user) throws UserAlreadyExistAuthenticationException {
        return service.registerUser(user);
    }

}

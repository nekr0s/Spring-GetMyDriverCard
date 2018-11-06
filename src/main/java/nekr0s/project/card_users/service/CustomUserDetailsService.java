package nekr0s.project.card_users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import nekr0s.project.card_users.exception.UserAlreadyExistAuthenticationException;
import nekr0s.project.card_users.models.CustomUserDetails;
import nekr0s.project.card_users.models.Role;
import nekr0s.project.card_users.models.User;
import nekr0s.project.card_users.repositories.RoleRepository;
import nekr0s.project.card_users.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final int ROLE_USER = 2;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("Incorrect email or password"));
        return optionalUser
                .map(CustomUserDetails::new).get();
    }

    public User getUserByUserId(int userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            return optional.get();
        } else throw new UsernameNotFoundException("User not found");
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User registerUser(User user) throws UserAlreadyExistAuthenticationException {
        // If user exists, throw exception
        if (alreadyExists(user.getUsername()))
            throw new UserAlreadyExistAuthenticationException("User already exists");

        Optional<Role> optionalRole = roleRepository.findById(ROLE_USER);
        optionalRole.ifPresent(role -> user.setRoles(new HashSet<>(Collections.singletonList(role))));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    private boolean alreadyExists(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.isPresent();
    }
}

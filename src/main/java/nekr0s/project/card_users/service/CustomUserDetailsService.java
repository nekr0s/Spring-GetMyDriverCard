package nekr0s.project.card_users.service;

import nekr0s.project.card_users.models.CustomUserDetails;
import nekr0s.project.card_users.models.Role;
import nekr0s.project.card_users.models.User;
import nekr0s.project.card_users.repositories.RoleRepository;
import nekr0s.project.card_users.repositories.UserRepository;
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
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
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

    public User registerUser(User user) {
        Optional<Role> optionalRole = roleRepository.findById(ROLE_USER);
        optionalRole.ifPresent(role -> user.setRoles(new HashSet<>(Collections.singletonList(role))));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}

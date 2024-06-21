package edu.supdevinci.eventmanagementapi.service.user;

import edu.supdevinci.eventmanagementapi.exception.UserNotFoundException;
import edu.supdevinci.eventmanagementapi.model.database.User;
import edu.supdevinci.eventmanagementapi.model.request.auth.SignupRequest;
import edu.supdevinci.eventmanagementapi.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserInformationService implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserInformationService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(SignupRequest request) {
        var user = mapToUserEntity(request);
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Cacheable(value = "users", key = "#email")
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    private User mapToUserEntity(SignupRequest request) {
        return User.builder()
                .withEmail(request.email())
                .withPassword(passwordEncoder.encode(request.password()))
                .withAge(request.age())
                .withCity(request.city())
                .withRating(BigDecimal.ZERO)
                .build();
    }
}

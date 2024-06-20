package edu.supdevinci.eventmanagementapi.service.user;

import edu.supdevinci.eventmanagementapi.exception.UserNotFoundException;
import edu.supdevinci.eventmanagementapi.model.database.User;
import edu.supdevinci.eventmanagementapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInformationService implements UserService {

    private final UserRepository userRepository;

    public UserInformationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
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
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}

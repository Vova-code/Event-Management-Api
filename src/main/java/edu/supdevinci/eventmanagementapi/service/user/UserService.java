package edu.supdevinci.eventmanagementapi.service.user;

import edu.supdevinci.eventmanagementapi.model.database.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User findByEmail(String email);

    List<User> findAll();

    boolean existsByEmail(String email);
}

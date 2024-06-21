package edu.supdevinci.eventmanagementapi.service.user;

import edu.supdevinci.eventmanagementapi.model.database.User;
import edu.supdevinci.eventmanagementapi.model.request.auth.SignupRequest;

import java.util.List;

public interface UserService {
    User register(SignupRequest signupRequest);

    User findByEmail(String email);

    List<User> findAll();

    boolean existsByEmail(String email);
}

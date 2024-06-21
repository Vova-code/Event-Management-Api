package edu.supdevinci.eventmanagementapi.repository;

import edu.supdevinci.eventmanagementapi.model.database.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}

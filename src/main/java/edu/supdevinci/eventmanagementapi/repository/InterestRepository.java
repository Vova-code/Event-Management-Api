package edu.supdevinci.eventmanagementapi.repository;

import edu.supdevinci.eventmanagementapi.model.database.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    Optional<Interest> findByName(String name);

    boolean existsByName(String name);
}

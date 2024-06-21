package edu.supdevinci.eventmanagementapi.repository;

import edu.supdevinci.eventmanagementapi.model.database.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findById(Long id);
    List<Event> findAll();
    List<Event> findByInterestsIn(List<Long> interests);
    Event save(Event event);
}

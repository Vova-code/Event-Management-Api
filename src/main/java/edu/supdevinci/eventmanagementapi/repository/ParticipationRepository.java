package edu.supdevinci.eventmanagementapi.repository;

import edu.supdevinci.eventmanagementapi.model.database.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    Optional<Participation> findById(Long id);

    List<Participation> findByUserId(Long userId);

    List<Participation> findByEventId(Long eventId);

    boolean existsById(Long id);
}

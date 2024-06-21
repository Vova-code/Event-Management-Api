package edu.supdevinci.eventmanagementapi.service.participation;

import edu.supdevinci.eventmanagementapi.model.database.Participation;

import java.util.List;
import java.util.Optional;

public interface ParticipationServicePort {

    Optional<Participation> findById(Long id);

    List<Participation> findByUserId(Long userId);

    List<Participation> findByEventId(Long eventId);

    boolean existsById(Long id);

    Participation save(Participation request);

    List<Participation> findAll();
}

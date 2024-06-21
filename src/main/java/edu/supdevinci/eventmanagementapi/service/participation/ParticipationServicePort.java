package edu.supdevinci.eventmanagementapi.service.participation;

import edu.supdevinci.eventmanagementapi.dto.ParticipationDto;
import edu.supdevinci.eventmanagementapi.model.database.Participation;

import java.util.List;
import java.util.Optional;

public interface ParticipationServicePort {

    Participation save(ParticipationDto participationDto);

    Optional<Participation> findById(Long id);

    List<Participation> findByUserId(Long userId);

    List<Participation> findByEventId(Long eventId);

    boolean existsById(Long id);

    List<Participation> findAll();

    void deleteById(Long id);
}

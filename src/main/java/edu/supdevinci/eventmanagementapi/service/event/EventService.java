package edu.supdevinci.eventmanagementapi.service.event;

import edu.supdevinci.eventmanagementapi.dto.EventDto;
import edu.supdevinci.eventmanagementapi.model.database.Event;
import edu.supdevinci.eventmanagementapi.model.database.Interest;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Event create(EventDto eventDto);

    List<Event> findAll();

    Optional<Event> findById(Long id);

    void delete(Long id);

    List<Event> findByInterest(List<Long> interestIds);
}

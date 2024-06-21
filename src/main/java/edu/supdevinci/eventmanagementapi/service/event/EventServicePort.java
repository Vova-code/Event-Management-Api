package edu.supdevinci.eventmanagementapi.service.event;

import edu.supdevinci.eventmanagementapi.dto.EventDto;
import edu.supdevinci.eventmanagementapi.model.database.Event;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventServicePort {
    Event create(EventDto eventDto);

    List<Event> findAll(Pageable pageable);

    Optional<Event> findById(Long id);

    void delete(Long id);

    List<Event> findByInterest(List<Long> interestIds);
}

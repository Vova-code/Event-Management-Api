package edu.supdevinci.eventmanagementapi.service.event;

import edu.supdevinci.eventmanagementapi.dto.EventDto;
import edu.supdevinci.eventmanagementapi.model.database.Event;
import edu.supdevinci.eventmanagementapi.repository.EventRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements EventServicePort {

    public final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @CacheEvict(value = "events", allEntries = true)
    public Event create(EventDto eventDto) {
        return eventRepository.save(Event
                .builder()
                .withName(eventDto.getName())
                .withLocation(eventDto.getLocation())
                .withPrice(eventDto.getPrice())
                .withType(eventDto.getType())
                .withDate(eventDto.getStartDate())
                .withInterests(eventDto.getInterests())
                .build()
        );
    }

    @Cacheable(value = "events")
    @Override
    public List<Event> findAll(Pageable pageable) {
        return eventRepository.findAll(pageable).getContent();
    }

    @Cacheable(value = "events", key = "#id")
    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Cacheable(value = "events", key = "#id")
    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> findByInterest(List<Long> interests) {
        return eventRepository.findByInterestsIn(interests);
    }
}

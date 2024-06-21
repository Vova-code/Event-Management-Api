package edu.supdevinci.eventmanagementapi.service.event;

import edu.supdevinci.eventmanagementapi.dto.EventDto;
import edu.supdevinci.eventmanagementapi.model.database.Event;
import edu.supdevinci.eventmanagementapi.model.database.Interest;
import edu.supdevinci.eventmanagementapi.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServicePort implements EventService {

    public final EventRepository eventRepository;

    public EventServicePort(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

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

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> findByInterest(List<Long> interests) {
        return eventRepository.findByInterestsIn(interests);
    }
}

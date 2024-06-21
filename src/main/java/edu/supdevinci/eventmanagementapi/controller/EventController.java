package edu.supdevinci.eventmanagementapi.controller;

import edu.supdevinci.eventmanagementapi.dto.EventDto;
import edu.supdevinci.eventmanagementapi.model.database.Event;
import edu.supdevinci.eventmanagementapi.service.event.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/events")
@Controller
public class EventController  {

    final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getEvents() {
        return ResponseEntity.ok(eventService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Event>> getEvent(@PathVariable String id) {
        return ResponseEntity.ok(eventService.findById(Long.parseLong(id)));
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventDto eventDto) {
        return ResponseEntity.ok(eventService.create(eventDto));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEvent(@RequestParam String id) {
        eventService.delete(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }
}

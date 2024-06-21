package edu.supdevinci.eventmanagementapi.controller;

import edu.supdevinci.eventmanagementapi.model.database.Participation;
import edu.supdevinci.eventmanagementapi.service.participation.ParticipationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/participations")
public class ParticipationController {

    private final ParticipationService participationService;

    public ParticipationController(ParticipationService participationService) {
        this.participationService = participationService;
    }

    @PostMapping
    public ResponseEntity<Participation> createParticipation(@RequestBody Participation participation) {
        Participation savedParticipation = participationService.save(participation);
        return ResponseEntity.ok(savedParticipation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participation> getParticipationById(@PathVariable Long id) {
        Optional<Participation> participation = participationService.findById(id);
        return participation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Participation>> getAllParticipations() {
        List<Participation> participations = participationService.findAll();
        return ResponseEntity.ok(participations);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Participation>> getParticipationsByUserId(@PathVariable Long userId) {
        List<Participation> participations = participationService.findByUserId(userId);
        return ResponseEntity.ok(participations);
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Participation>> getParticipationsByEventId(@PathVariable Long eventId) {
        List<Participation> participations = participationService.findByEventId(eventId);
        return ResponseEntity.ok(participations);
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsParticipationById(@PathVariable Long id) {
        boolean exists = participationService.existsById(id);
        return ResponseEntity.ok(exists);
    }
}

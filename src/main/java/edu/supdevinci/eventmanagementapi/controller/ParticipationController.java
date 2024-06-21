package edu.supdevinci.eventmanagementapi.controller;

import edu.supdevinci.eventmanagementapi.dto.ParticipationDto;
import edu.supdevinci.eventmanagementapi.model.database.Participation;
import edu.supdevinci.eventmanagementapi.service.participation.ParticipationService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Participation> createParticipation(@RequestBody ParticipationDto participationDto) {
        return ResponseEntity.ok(participationService.create(participationDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participation> getParticipationById(@PathVariable Long id) {
        Optional<Participation> participationOptional = participationService.findById(id);
        return participationOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipation(@PathVariable Long id) {
        if (participationService.existsById(id)) {
            participationService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
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
}

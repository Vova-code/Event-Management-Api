package edu.supdevinci.eventmanagementapi.service.participation;

import edu.supdevinci.eventmanagementapi.model.database.Participation;
import edu.supdevinci.eventmanagementapi.repository.ParticipationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipationService implements ParticipationServicePort {

    private final ParticipationRepository participationRepository;

    public ParticipationService(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    @Override
    public Optional<Participation> findById(Long id) {
        return this.participationRepository.findById(id);
    }

    @Override
    public List<Participation> findByUserId(Long userId) {
        return this.participationRepository.findByUserId(userId);
    }

    @Override
    public List<Participation> findByEventId(Long eventId) {
        return this.participationRepository.findByEventId(eventId);
    }

    @Override
    public boolean existsById(Long id) {
        return this.participationRepository.existsById(id);
    }

    @Override
    public Participation save(Participation request) {
        return this.participationRepository.save(request);
    }

    @Override
    public List<Participation> findAll() {
        return this.participationRepository.findAll();
    }
}

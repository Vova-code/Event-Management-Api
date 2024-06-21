package edu.supdevinci.eventmanagementapi.service.participation;

import edu.supdevinci.eventmanagementapi.dto.ParticipationDto;
import edu.supdevinci.eventmanagementapi.model.database.Participation;
import edu.supdevinci.eventmanagementapi.repository.ParticipationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipationService implements ParticipationServicePort {

    private final ParticipationRepository participationRepository;

    @Autowired
    public ParticipationService(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    @CacheEvict(value = "participations", allEntries = true)
    @Override
    public Participation create(ParticipationDto participationDto) {
        Participation participation = Participation
                .builder()
                .withIsConfirmed(participationDto.getIsConfirmed())
                .withMessage(participationDto.getMessage())
                .withCreatedAt(new Date())
                .build();

        return participationRepository.save(participation);
    }
    @Override
    public List<Participation> findAll() {
        return participationRepository.findAll();
    }

    @Override
    public Optional<Participation> findById(Long id) {
        return participationRepository.findById(id);
    }

    @Cacheable(value = "events", key = "#id")
    @Override
    public void deleteById(Long id) {
        participationRepository.deleteById(id);
    }

    @Override
    public List<Participation> findByUserId(Long userId) {
        return participationRepository.findByUserId(userId);
    }

    @Override
    public List<Participation> findByEventId(Long eventId) {
        return participationRepository.findByEventId(eventId);
    }

    @Cacheable(value = "participations", key = "#id")
    @Override
    public boolean existsById(Long id) {
        return participationRepository.existsById(id);
    }
}

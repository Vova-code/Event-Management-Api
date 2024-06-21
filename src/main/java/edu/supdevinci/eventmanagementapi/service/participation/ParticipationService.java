package edu.supdevinci.eventmanagementapi.service.participation;

import edu.supdevinci.eventmanagementapi.dto.ParticipationDto;
import edu.supdevinci.eventmanagementapi.model.database.Participation;
import edu.supdevinci.eventmanagementapi.repository.ParticipationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Participation save(ParticipationDto participationDto) {
        Participation participation = new Participation();
        BeanUtils.copyProperties(participationDto, participation);

        // Set current timestamp for createdAt
        participation.setCreatedAt(new Date());

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

    @Override
    public boolean existsById(Long id) {
        return participationRepository.existsById(id);
    }
}

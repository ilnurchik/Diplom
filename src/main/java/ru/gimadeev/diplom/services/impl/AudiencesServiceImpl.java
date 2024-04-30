package ru.gimadeev.diplom.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gimadeev.diplom.dto.AudiencesForm;
import ru.gimadeev.diplom.models.Audience;
import ru.gimadeev.diplom.repositories.AudiencesRepository;
import ru.gimadeev.diplom.services.AudiencesService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AudiencesServiceImpl implements AudiencesService {

    private final AudiencesRepository audiencesRepository;

    @Override
    public List<Audience> getAllAudiences() {
        return audiencesRepository.findAllByStateNot(Audience.State.DELETED);
    }

    @Override
    public void addAudiences(AudiencesForm audience) {
        Audience newAudiences = Audience.builder()
                .email(audience.getEmail())
                .lastName(audience.getLastName())
                .firstName(audience.getFirstName())
                .state(Audience.State.CONFIRMED)
                .build();
        audiencesRepository.save(newAudiences);
    }

    @Override
    public Audience getAudience(Long id) {
        return audiencesRepository.findById(id).orElseThrow();
    }


    @Override
    public void updateAudiences(Long audiencesId, AudiencesForm updateAudiences) {
        Audience audiencesForUpdate = audiencesRepository.findById(audiencesId).orElseThrow();
        audiencesForUpdate.setFirstName(updateAudiences.getFirstName());
        audiencesForUpdate.setLastName(updateAudiences.getLastName());
        audiencesForUpdate.setAge(updateAudiences.getAge());
        audiencesRepository.save(audiencesForUpdate);
    }

    @Override
    public void deleteAudiences(Long audienceIs) {
        Audience audiencesForDeleted = audiencesRepository.findById(audienceIs).orElseThrow();
        audiencesForDeleted.setState(Audience.State.DELETED);
        audiencesRepository.save(audiencesForDeleted);
    }
}

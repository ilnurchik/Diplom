package ru.gimadeev.diplom.services;

import ru.gimadeev.diplom.dto.AudiencesForm;
import ru.gimadeev.diplom.models.Audience;

import java.util.List;

public interface AudiencesService {


    List<Audience> getAllAudiences();

    void addAudiences(AudiencesForm audiences);

    Audience getAudience(Long id);

    void updateAudiences(Long audiencesId, AudiencesForm audiences);

    void deleteAudiences(Long audienceId);

}

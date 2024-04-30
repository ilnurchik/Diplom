package ru.gimadeev.diplom.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gimadeev.diplom.dto.FilmsForm;
import ru.gimadeev.diplom.models.Film;
import ru.gimadeev.diplom.repositories.FilmsRepository;
import ru.gimadeev.diplom.services.FilmsService;

import java.time.LocalTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FilmsServiceImpl implements FilmsService {

    private final FilmsRepository filmsRepository;


    @Override
    public List<Film> getAllFilms() {
        return filmsRepository.findAllByStateNot(Film.State.DELETED);
    }

    @Override
    public void addFilms(FilmsForm film) {
        Film newFilm = Film.builder()
                .name(film.getName())
                .summary(film.getSummary())
                .state(Film.State.CONFIRMED)
                .startTime(LocalTime.of(00, 00))
                .finishTime(LocalTime.of(00, 00))
                .build();
        filmsRepository.save(newFilm);
    }

    @Override
    public Film getFilm(Long filmId) {
        return filmsRepository.findById(filmId).orElseThrow();
    }

    @Override
    public void updateFilms(Long filmId, FilmsForm updateFilm) {
        Film FilmsForUpdate = filmsRepository.findById(filmId).orElseThrow();
        FilmsForUpdate.setName(updateFilm.getName());
        FilmsForUpdate.setSummary(updateFilm.getSummary());
        FilmsForUpdate.setStartTime(updateFilm.getStartTime());
        FilmsForUpdate.setFinishTime(updateFilm.getFinishTime());
        filmsRepository.save(FilmsForUpdate);
    }

    @Override
    public void deleteFilms(Long filmIs) {
        Film filmsForDeleted = filmsRepository.findById(filmIs).orElseThrow();
        filmsForDeleted.setState(Film.State.DELETED);
        filmsForDeleted.setCinemaHall(null);
        filmsRepository.save(filmsForDeleted);
    }

}

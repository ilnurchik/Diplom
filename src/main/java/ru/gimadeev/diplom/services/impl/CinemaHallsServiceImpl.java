package ru.gimadeev.diplom.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gimadeev.diplom.dto.CinemaHallsForm;
import ru.gimadeev.diplom.models.Audience;
import ru.gimadeev.diplom.models.CinemaHall;
import ru.gimadeev.diplom.models.Film;
import ru.gimadeev.diplom.repositories.AudiencesRepository;
import ru.gimadeev.diplom.repositories.CinemaHallsRepository;
import ru.gimadeev.diplom.repositories.FilmsRepository;
import ru.gimadeev.diplom.services.CinemaHallsService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaHallsServiceImpl implements CinemaHallsService {

    private final CinemaHallsRepository CinemaHallsRepository;

    private final FilmsRepository filmsRepository;

    private final AudiencesRepository audiencesRepository;

    @Override
    public List<CinemaHall> getAllCinemaHalls() {
        AudiencesRepository cinemaHallsRepository;
        return CinemaHallsRepository.findAllByStateNot(CinemaHall.State.DELETED);
    }

    @Override
    public void addCinemaHalls(CinemaHallsForm cinemaHall) {
        CinemaHall newCinemaHall = CinemaHall.builder()
                .title(cinemaHall.getTitle())
                .description(cinemaHall.getDescription())
                .start(LocalDate.EPOCH)
                .finish(LocalDate.EPOCH)
                .state(CinemaHall.State.CONFIRMED)
                .build();
        CinemaHallsRepository.save(newCinemaHall);
    }

    @Override
    public CinemaHall getCinemaHall(Long cinemaHallId) {
        return CinemaHallsRepository.findById(cinemaHallId).orElseThrow();
    }

    @Override
    public void updateCinemaHalls(Long cinemaHallId, CinemaHallsForm cinemaHall) {
        CinemaHall cinemaHallForUpdate = CinemaHallsRepository.findById(cinemaHallId).orElseThrow();
        cinemaHallForUpdate.setTitle(cinemaHall.getTitle());
        cinemaHallForUpdate.setDescription(cinemaHall.getDescription());
        cinemaHallForUpdate.setStart(cinemaHall.getStart());
        cinemaHallForUpdate.setFinish(cinemaHall.getFinish());
        CinemaHallsRepository.save(cinemaHallForUpdate);
    }


    @Override
    public List<Film> getNotInCinemaHallFilms() {
        return filmsRepository.findAllByCinemaHallNullAndState(Film.State.CONFIRMED);
    }

    @Override
    public List<Film> getInCinemaHallFilms(Long cinemaHallId) {
        CinemaHall cinemaHall = CinemaHallsRepository.findById(cinemaHallId).orElseThrow();
        return filmsRepository.findAllByCinemaHall(cinemaHall);
    }


    @Override
    public void addFilmToCinemaHall(Long cinemaHallId, Long filmId) {
        CinemaHall cinemaHall = CinemaHallsRepository.findById(cinemaHallId).orElseThrow();
        Film film = filmsRepository.findById(filmId).orElseThrow();
        film.setCinemaHall(cinemaHall);
        filmsRepository.save(film);
    }


    @Override
    public void addAudienceToCinemaHall(Long cinemaHallId, Long audienceId) {
        CinemaHall cinemaHall = CinemaHallsRepository.findById(cinemaHallId).orElseThrow();
        Audience audience = audiencesRepository.findById(audienceId).orElseThrow();
        audience.getCinemaHall().add(cinemaHall);
        audiencesRepository.save(audience);
    }

    @Override
    public List<Audience> getNotInCinemaHallAudience(Long cinemaHallId) {
        CinemaHall cinemaHall = CinemaHallsRepository.findById(cinemaHallId).orElseThrow();
        return audiencesRepository.findAllByCinemaHallNotContainsAndState(cinemaHall, Audience.State.CONFIRMED);
    }

    @Override
    public List<Audience> getInCinemaHallAudience(Long cinemaHallId) {
        CinemaHall cinemaHall = CinemaHallsRepository.findById(cinemaHallId).orElseThrow();
        return audiencesRepository.findAllByCinemaHallContains(cinemaHall);
    }


    @Override
    public void removeFilm(Long filmId) {
        Film film = filmsRepository.findById(filmId).orElseThrow();
        film.setCinemaHall(null);
        filmsRepository.save(film);
    }

    @Override
    public void deleteСinemaHalls(Long cinemaHallId) {
        CinemaHall cinemaHallForDelete = CinemaHallsRepository.findById(cinemaHallId).orElseThrow();
        cinemaHallForDelete.setState(CinemaHall.State.DELETED);
        CinemaHallsRepository.save(cinemaHallForDelete);
    }
}
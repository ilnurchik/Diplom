package ru.gimadeev.diplom.services;

import ru.gimadeev.diplom.dto.CinemaHallsForm;
import ru.gimadeev.diplom.models.Audience;
import ru.gimadeev.diplom.models.CinemaHall;
import ru.gimadeev.diplom.models.Film;

import java.util.List;


public interface CinemaHallsService {

    List<CinemaHall> getAllCinemaHalls();

    void addCinemaHalls(CinemaHallsForm department);

    CinemaHall getCinemaHall(Long cinemaHallId);

    void updateCinemaHalls(Long cinemaHallId, CinemaHallsForm cinemaHall);


    void addFilmToCinemaHall(Long cinemaHallId, Long bookId);

    List<Film> getNotInCinemaHallFilms();

    List<Film> getInCinemaHallFilms(Long cinemaHallId);

    void addAudienceToCinemaHall(Long cinemaHallId, Long audienceId);

    List<Audience> getNotInCinemaHallAudience(Long cinemaHallId);

    List<Audience> getInCinemaHallAudience(Long cinemaHallId);

    void removeFilm(Long filmId);

    void deleteСinemaHalls(Long cinemaHallId);
}

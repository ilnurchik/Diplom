package ru.gimadeev.diplom.services;

import ru.gimadeev.diplom.dto.FilmsForm;
import ru.gimadeev.diplom.models.Film;

import java.util.List;

public interface FilmsService {

    List<Film> getAllFilms();

    void addFilms(FilmsForm films);


    Film getFilm(Long filmId);

    void updateFilms(Long filmId, FilmsForm films);

    void deleteFilms(Long filmId);

}

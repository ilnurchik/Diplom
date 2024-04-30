package ru.gimadeev.diplom.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gimadeev.diplom.dto.FilmsForm;
import ru.gimadeev.diplom.services.FilmsService;


@RequiredArgsConstructor
@RequestMapping(value = "/films")
@Controller
public class FilmsControllers {

    private final FilmsService filmsService;


    @GetMapping
    public String getFilmsPage(Model model) {
        model.addAttribute("films", filmsService.getAllFilms());
        return "films_page";
    }

    @PostMapping
    public String addFilms(FilmsForm films) {
        filmsService.addFilms(films);
        return "redirect:/films";
    }

    @GetMapping("/{film-id}")
    public String getFilmPage(@PathVariable("film-id") Long filmId, Model model) {
        model.addAttribute("film", filmsService.getFilm(filmId));
        return "film_page";
    }

    @PostMapping("/{film-id}/update")
    public String updateFilms(@PathVariable("film-id") Long filmId, FilmsForm films) {
        filmsService.updateFilms(filmId, films);
        return "redirect:/films/";
    }

    @GetMapping("/{film-id}/delete")
    public String deleteFilms(@PathVariable("film-id") Long filmId) {
        filmsService.deleteFilms(filmId);
        return "redirect:/films";
    }
}


package ru.gimadeev.diplom.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gimadeev.diplom.dto.CinemaHallsForm;
import ru.gimadeev.diplom.services.CinemaHallsService;

@Controller
@RequestMapping(value = "/cinemaHalls")
@RequiredArgsConstructor
public class CinemaHallsControllers {

    private final CinemaHallsService cinemaHallsService;

    @GetMapping
    public String getCinemaHallsPage(Model model) {
        model.addAttribute("cinemaHalls", cinemaHallsService.getAllCinemaHalls());
        return "cinemaHalls_page";
    }

    @PostMapping
    public String addCinemaHalls(CinemaHallsForm cinemaHalls) {
        cinemaHallsService.addCinemaHalls(cinemaHalls);
        return "redirect:/cinemaHalls";
    }

    @GetMapping("/{cinemaHall-id}")
    public String getCinemaHallsPage(@PathVariable("cinemaHall-id") Long cinemaHallId, Model model) {
        model.addAttribute("cinemaHall", cinemaHallsService.getCinemaHall(cinemaHallId));
        model.addAttribute("notInCinemaHallFilms", cinemaHallsService.getNotInCinemaHallFilms());
        model.addAttribute("inCinemaHallFilms", cinemaHallsService.getInCinemaHallFilms(cinemaHallId));
        model.addAttribute("notInCinemaHallAudience", cinemaHallsService.getNotInCinemaHallAudience(cinemaHallId));
        model.addAttribute("inCinemaHallAudiences", cinemaHallsService.getInCinemaHallAudience(cinemaHallId));
        return "cinemaHall_page";
    }

    @PostMapping("/{cinemaHall-id}/update")
    public String updateCinemaHalls(@PathVariable("cinemaHall-id") Long cinemaHallId, CinemaHallsForm cinemaHall) {
        cinemaHallsService.updateCinemaHalls(cinemaHallId, cinemaHall);
        return "redirect:/cinemaHalls/" + cinemaHallId;
    }

    @GetMapping("/{cinemaHall-id}/delete")
    public String deleteСinemaHalls(@PathVariable("cinemaHall-id") Long cinemaHallId) {
        cinemaHallsService.deleteСinemaHalls(cinemaHallId);
        return "redirect:/cinemaHalls";
    }

    @PostMapping("/{cinemaHall-id}/audiences")
    public String addAudienceToCinemaHall(@PathVariable("cinemaHall-id") Long cinemaHallId,
                                          @RequestParam("audience-id") Long audienceId) {
        cinemaHallsService.addAudienceToCinemaHall(cinemaHallId, audienceId);
        return "redirect:/cinemaHalls/" + cinemaHallId;
    }

    @PostMapping("/{cinemaHall-id}/films")
    public String addFilmToCinemaHall(@PathVariable("cinemaHall-id") Long cinemaHallId,
                                      @RequestParam("film-id") Long filmId) {
        cinemaHallsService.addFilmToCinemaHall(cinemaHallId, filmId);
        return "redirect:/cinemaHalls/" + cinemaHallId;
    }

    @GetMapping("/{cinemaHall-id}/remove")
    public String removeFilm(@PathVariable("cinemaHall-id") Long cinemaHallId,
                             @RequestParam("film-id") Long filmId) {
        cinemaHallsService.removeFilm(filmId);
        return "redirect:/cinemaHalls/" + cinemaHallId;
    }

}

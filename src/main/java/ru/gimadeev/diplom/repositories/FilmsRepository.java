package ru.gimadeev.diplom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gimadeev.diplom.models.CinemaHall;
import ru.gimadeev.diplom.models.Film;

import java.util.List;


@Repository
public interface FilmsRepository extends JpaRepository<Film, Long> {
    List<Film> findAllByStateNot(Film.State state);

    List<Film> findAllByCinemaHallNullAndState(Film.State state);

    List<Film> findAllByCinemaHall(CinemaHall cinemaHall);
}

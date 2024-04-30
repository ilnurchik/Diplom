package ru.gimadeev.diplom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gimadeev.diplom.models.Audience;
import ru.gimadeev.diplom.models.CinemaHall;

import java.util.List;


public interface AudiencesRepository extends JpaRepository<Audience, Long> {

    List<Audience> findAllByStateNot(Audience.State state);

    List<Audience> findAllByCinemaHallNotContainsAndState(CinemaHall cinemaHall, Audience.State state);

    List<Audience> findAllByCinemaHallContains(CinemaHall cinemaHall);
}


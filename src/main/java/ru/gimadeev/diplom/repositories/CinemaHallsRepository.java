package ru.gimadeev.diplom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gimadeev.diplom.models.CinemaHall;

import java.util.List;


@Repository
public interface CinemaHallsRepository extends JpaRepository<CinemaHall, Long> {

    List<CinemaHall> findAllByStateNot(CinemaHall.State state);


}
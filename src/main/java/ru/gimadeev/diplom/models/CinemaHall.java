package ru.gimadeev.diplom.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"film", "audiences"})
@ToString
@Builder
@Entity
public class CinemaHall {

    public enum State {
        CONFIRMED, DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Column(name = "start_work")
    private LocalDate start;

    private LocalDate finish;

    @ManyToMany(mappedBy = "cinemaHall", fetch = FetchType.EAGER)
    private Set<Audience> audiences;

    @OneToMany(mappedBy = "cinemaHall", fetch = FetchType.EAGER)
    private Set<Film> films;

    @Enumerated(value = EnumType.STRING)
    private State state;
}

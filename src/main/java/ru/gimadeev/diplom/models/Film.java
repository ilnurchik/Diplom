package ru.gimadeev.diplom.models;


import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "cinemaHall")
@ToString(exclude = "cinemaHall")
@Builder
@Entity
public class Film {

    public enum State {
        CONFIRMED, DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String summary;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "finish_time")
    private LocalTime finishTime;

    @ManyToOne
    @JoinColumn(name = "cinemaHall_id")
    private CinemaHall cinemaHall;

    @Enumerated(value = EnumType.STRING)
    private State state;
}

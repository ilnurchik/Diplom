package ru.gimadeev.diplom.models;


import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"cinemaHall"})
@ToString(exclude = {"cinemaHall"})
@Builder
@Entity
@DynamicInsert
public class Audience {


    public enum State {
        CONFIRMED, DELETED
    }

    public enum Role {
        USER, ADMIN
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(columnDefinition = "int default 0")
    @Check(constraints = "age >= 0 and age <= 90")
    private Integer age;

    @Column(name = "is_worker")
    private Boolean isWorker;

    private Double average;

    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "audience_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "cinemaHall_id", referencedColumnName = "id")})
    private Set<CinemaHall> cinemaHall;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;

}

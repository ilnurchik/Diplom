package ru.gimadeev.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FilmsForm {

    private String name;
    private String summary;
    private LocalTime startTime;
    private LocalTime finishTime;
}

package ru.gimadeev.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AudiencesForm {

    private String email;
    private String firstName;
    private String lastName;
    private Integer age;
}

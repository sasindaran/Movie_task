package com.projectalpha.movie.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private int id;

    @NotBlank(message = "Movie name cannot be empty")
    private String name;

    @NotBlank(message = "Description cannot be empty")
    private String description;

}

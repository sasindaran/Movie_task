package com.projectalpha.movie.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
public class Movie {

    private int id;

    @NotBlank(message = "Movie name cannot be empty")
    private String name;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    // Constructor without id (for POST requests)
    public Movie(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Constructor with id (for repository initialization)
    public Movie(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}

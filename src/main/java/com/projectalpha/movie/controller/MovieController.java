package com.projectalpha.movie.controller;

import com.projectalpha.movie.model.Movie;
import com.projectalpha.movie.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) {
        Movie savedMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {

        return movieService.getMovieById(id)
                .map(movie -> ResponseEntity.ok(movie))
                .orElse(
                        ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMovie(
            @PathVariable int id,
            @Valid @RequestBody Movie movie) {

        Movie updatedMovie = movieService.updateMovie(id, movie);

        if (updatedMovie == null) {
            return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id) {
        boolean deleted = movieService.deleteMovie(id);

        if (!deleted) {
            return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("Movie deleted successfully");
    }
}

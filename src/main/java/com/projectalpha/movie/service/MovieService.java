package com.projectalpha.movie.service;

import com.projectalpha.movie.model.Movie;
import com.projectalpha.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // CREATE
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // READ by ID
    public Movie getMovieById(int id) {
        return movieRepository.findById(id);
    }

    // READ all
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // UPDATE
    public Movie updateMovie(int id, Movie movie) {
        return movieRepository.update(id, movie);
    }

    // DELETE
    public boolean deleteMovie(int id) {
        return movieRepository.deleteById(id);
    }
}

package com.projectalpha.movie.repository;

import com.projectalpha.movie.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class MovieRepository {

    private final List<Movie> movies = new ArrayList<>();
    private int idCounter = 1;

    //Dummy data
    public MovieRepository() {
        movies.add(new Movie(idCounter++, "Inception", "Sci-fi thriller by Christopher Nolan"));
        movies.add(new Movie(idCounter++, "Interstellar", "Space exploration and time dilation"));
        movies.add(new Movie(idCounter++, "The Dark Knight", "Batman vs Joker"));
    }

    // Create a new movie (CREATE)
    public Movie save(Movie movie) {
        movie.setId(idCounter++);
        movies.add(movie);
        return movie;
    }

    // Find movie by ID (READ)
    public Movie findById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

   // Get all movies (READ)
    public List<Movie> findAll() {
        return movies;
    }

    // UPDATE
    public Movie update(int id, Movie updatedMovie) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                movie.setName(updatedMovie.getName());
                movie.setDescription(updatedMovie.getDescription());
                return movie;
            }
        }
        return null;
    }

    // DELETE
    public boolean deleteById(int id) {
       return movies.removeIf(movie -> movie.getId() == id);
    }
}

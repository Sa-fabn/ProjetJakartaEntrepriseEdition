package org.efrei.demo.services;

import org.efrei.demo.models.Movie;
import org.efrei.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }


    public List<Movie> findAll() {
        return repository.findAll();
    }

    public void create(Movie movie) {
        repository.save(movie);
    }

    public Movie findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Movie movie) {
        Movie updatedMovie = findById(id);
        if (updatedMovie != null) { // Check if the movie exists
            updatedMovie.setTitle(movie.getTitle()); // Update title
            updatedMovie.setLastname(movie.getLastname()); // Update lastname
            repository.save(updatedMovie);
        }
    }
}

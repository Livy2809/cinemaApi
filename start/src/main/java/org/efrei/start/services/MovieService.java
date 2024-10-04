package org.efrei.start.services;

import org.efrei.start.models.Movie;
import org.efrei.start.repositories.MovieRepository;
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

    public Movie findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void create(Movie movie) {
        repository.save(movie);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void update(Long id, Movie movie) {
        Movie updatedMovie = findById(id);
        updatedMovie.setTitle(movie.getTitle());
        updatedMovie.setDirector(movie.getDirector());
        repository.save(updatedMovie);
    }
}

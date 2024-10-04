package org.efrei.start.services;

import org.efrei.start.dto.CreateDirector;
import org.efrei.start.models.Director;
import org.efrei.start.models.Movie;
import org.efrei.start.repositories.DirectorRepository;
import org.efrei.start.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    private final DirectorRepository repository;
    private final MovieRepository movieRepository;

    @Autowired
    public DirectorService(DirectorRepository repository, MovieRepository movieRepository) {
        this.repository = repository;
        this.movieRepository = movieRepository;
    }

    public List<Director> findAll() {
        return repository.findAll();
    }

    public void create(CreateDirector createDirector) {
        Director director = new Director();
        director.setFirstname(createDirector.getFirstName());
        director.setName(createDirector.getName());
        repository.save(director);
    }

    public Director findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void update(Long id, Director director) {
        Director updatedDirector = findById(id);
        updatedDirector.setName(director.getName());
        updatedDirector.setFirstname(director.getFirstname());
        repository.save(updatedDirector);
    }

    public void addMovieToDirector(Long directorId, Movie movie) {
        Director director = findById(directorId);
        if (director != null) {
            movie.setDirector(director);
            movieRepository.save(movie);
        }
    }
}

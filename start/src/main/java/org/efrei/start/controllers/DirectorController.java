package org.efrei.start.controllers;

import org.efrei.start.models.Movie;
import org.efrei.start.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping("/{directorId}/movies")
    public void addMovieToDirector(@PathVariable Long directorId, @RequestBody Movie movie) {
        directorService.addMovieToDirector(directorId, movie);
    }

    // Additional endpoints (like find, create, delete) can be added here
}

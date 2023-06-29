package com.spaceapi.controllers;

import com.spaceapi.DTOS.MovieDTO;
import com.spaceapi.models.MovieModel;
import com.spaceapi.services.movieServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/movie")
@CrossOrigin("*")
public class movieController {
    private final movieServices servicesMovie;

    public movieController(movieServices service){
        this.servicesMovie = service;
    }

    @PostMapping("/addMovie")
    public ResponseEntity createMovie(@RequestBody MovieDTO movie){
        try{
            var newMovie = new MovieModel(movie);
            servicesMovie.SaveMovie(newMovie);
            return ResponseEntity.ok("Movie created successfully");
        }catch (Error e){
            return ResponseEntity.status(500).body("Movie not created Error : " + e);
        }
    }
}

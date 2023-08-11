package com.spaceapi.controllers;

import com.spaceapi.DTOS.MovieDTO;
import com.spaceapi.models.MovieModel;
import com.spaceapi.services.movieServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
@CrossOrigin("*")
public class movieController {
    private final movieServices servicesMovie;

    public movieController(movieServices service){

        this.servicesMovie = service;
    }

    @PostMapping("/addMovie")
    public ResponseEntity createMovie(@RequestBody MovieDTO movie){
        ResponseEntity response = servicesMovie.SaveMovie(movie);
        return response;
    }

    @GetMapping("/list")
    public ResponseEntity getAllMovie(){
        try{
            var movies = servicesMovie.getAllMovies();
            return ResponseEntity.ok(movies);
        }catch(Error e){
            return ResponseEntity.status(400).body("Any Movie available");
        }
    }
}

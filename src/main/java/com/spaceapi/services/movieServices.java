package com.spaceapi.services;

import com.spaceapi.models.MovieModel;
import com.spaceapi.repositories.movieRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class movieServices {
    private final movieRepositories movieRepo;

    @Autowired
    public movieServices(movieRepositories movieRepo){
        this.movieRepo = movieRepo;
    }

    public void SaveMovie(MovieModel movie){
        movieRepo.save(movie);
    }

    public List<MovieModel> getAllMovies(){
        return movieRepo.findAll();
    }

}

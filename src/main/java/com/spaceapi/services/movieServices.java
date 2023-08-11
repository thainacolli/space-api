package com.spaceapi.services;

import com.spaceapi.DTOS.MovieDTO;
import com.spaceapi.models.MovieModel;
import com.spaceapi.repositories.movieRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class movieServices {
    private final movieRepositories movieRepo;

    @Autowired
    public movieServices(movieRepositories movieRepo){
        this.movieRepo = movieRepo;
    }

    public ResponseEntity SaveMovie(MovieDTO movie){
        try{
            MovieModel newMovie = new MovieModel();
            newMovie.setTitle(movie.title());
            newMovie.setSynopsis(movie.synopsis());
            newMovie.setDurationMinutes(movie.durationMinutes());
            newMovie.setCoverImage(movie.coverImage());
            newMovie.setRelease_date(movie.release_date());
            newMovie.setImage(movie.image());
            newMovie.setGenre(movie.genreMovie());
            Optional<MovieModel> movieResult = Optional.ofNullable(movieRepo.save(newMovie));
            if(movieResult.isPresent()){
                return ResponseEntity.status(200).body(newMovie);
            }else{
                return ResponseEntity.status(500).body(newMovie);
            }
        }catch(Error e){
            return ResponseEntity.status(500).body(e);
        }


    }

    public List<MovieModel> getAllMovies(){
        return movieRepo.findAll();
    }

}

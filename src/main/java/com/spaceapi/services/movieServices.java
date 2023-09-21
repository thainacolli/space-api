package com.spaceapi.services;

import com.spaceapi.DTOS.MovieDTO;
import com.spaceapi.models.MovieModel;
import com.spaceapi.models.UserModel;
import com.spaceapi.repositories.movieRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class movieServices {
    private final movieRepositories movieRepo;

    @Autowired UserServices userservices;

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

            UserModel user = userservices.findById(movie.user());
            newMovie.setUser(user);

            Optional<MovieModel> movieResult = Optional.ofNullable(movieRepo.save(newMovie));

            if(movieResult.isPresent()){
                return ResponseEntity.status(201).body(movieResult);
            }else{
                return ResponseEntity.status(500).body(movieResult);
            }

        }catch(Error e){
            return ResponseEntity.status(500).body(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    public List<MovieModel> getAllMovies(){
        return movieRepo.findAll();
    }

    public ResponseEntity deleteMovieById(Long id){
        try {
            Optional<MovieModel> movie = movieRepo.findById(id);

            if (movie.isPresent()) {
                movieRepo.deleteById(id);
                return ResponseEntity.status(200).body("Movie deleted successfully");
            } else {
                return ResponseEntity.status(404).body("Movie not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting movie");
        }
    }

    public ResponseEntity getMovieById(Long id){
        try{
            Optional<MovieModel> movie = movieRepo.findById(id);
            if(movie.isPresent()){
                return ResponseEntity.status(200).body(movie);
            }else{
                return ResponseEntity.status(400).body("Movie not found");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error this movie isent available");
        }
    }

    public ResponseEntity editMovie(MovieModel movie){
        try{
            Optional<MovieModel> movieSaved = Optional.ofNullable(movieRepo.save(movie));
            if(movieSaved.isPresent()){
                return ResponseEntity.status(200).body(movieSaved);
            }else{
                return ResponseEntity.status(400).body("This movie is not available");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error on editing");
        }

    }
}

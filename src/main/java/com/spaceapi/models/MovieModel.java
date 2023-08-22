package com.spaceapi.models;

import com.spaceapi.DTOS.MovieDTO;
import com.spaceapi.ENUMS.genreMovieEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table(name="movies")
@Entity
@Data
public class MovieModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Integer durationMinutes;

    @NotNull
    private String coverImage;
    @NotNull
    private String title;
    @NotNull
    private String image;
    @NotNull
    private String synopsis;
    @NotNull
    private genreMovieEnum genre;

    private Date release_date;
    //List<UsuarioModel> usuarioId;

    public MovieModel(){

    }

    public MovieModel(MovieDTO movie){
        this.durationMinutes = movie.durationMinutes();
        this.image = movie.image();
        this.genre = movie.genreMovie();
        this.release_date = movie.release_date();
        this.synopsis = movie.synopsis();
        this.title = movie.title();
        //this.usuarioId = movie.userID();
        this.coverImage = movie.coverImage();
    }

}

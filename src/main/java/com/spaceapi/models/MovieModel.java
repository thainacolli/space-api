package com.spaceapi.models;

import com.spaceapi.DTOS.MovieDTO;
import com.spaceapi.ENUMS.genreMovieEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Table(name="movies")
@Entity
@Data
public class MovieModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer durationMinutes;
    //List<UsuarioModel> usuarioId;

    private String coverImage;
    private String title;
    private String image;
    private String synopsis;
    private genreMovieEnum genre;
    private Date release_date;

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
    public MovieModel(){

    }
}

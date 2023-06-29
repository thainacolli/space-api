package com.spaceapi.models;

import com.spaceapi.DTOS.MovieDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "movies")
public class MovieModel extends MidiaModel{
    @Id
    String id;
    Integer durationMinutes;
    List<UsuarioModel> usuarioId;

    public MovieModel(MovieDTO movie){
        this.durationMinutes = movie.durationMinutes();
        this.image = movie.image();
        this.genre = movie.genreMovie();
        this.release_date = movie.release_date();
        this.synopsis = movie.synopsis();
        this.title = movie.title();
        this.usuarioId = movie.userID();
        this.coverImage = movie.coverImage();
    }
    public MovieModel(){

    }
}

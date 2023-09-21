package com.spaceapi.models;

import com.spaceapi.DTOS.MovieDTO;
import com.spaceapi.DTOS.SerieDTO;
import com.spaceapi.ENUMS.genreMovieEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table(name="series")
@Entity
@Data
public class SerieModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value = 0, message = "O valor deve ser no mínimo 0")
    private Integer epQt;
    @Min(value = 0, message = "O valor deve ser no mínimo 0")
    private Integer seasonQt;
    @NotNull
    private String title;
    @NotNull
    private String image;
    @NotNull
    private String coverImage;
    @NotNull
    private String synopsis;
    @NotNull
    private genreMovieEnum genre;
    @NotNull(message = "A data não pode ser nula")
    private Date release_date;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserModel user;

    public SerieModel(){

    }

    public SerieModel(SerieDTO serie){
        this.epQt = serie.epQtd();
        this.seasonQt = serie.seasonQtd();
    }


}
package com.spaceapi.models;

import com.spaceapi.ENUMS.genreMovieEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Table(name= "animes")
@Entity
@Data
public class AnimeModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studio;
    private Integer epQt;
    private Integer seasonQt;
    @NotNull
    private String title;
    @NotNull
    private String image;
    @NotNull
    private String synopsis;
    @NotNull
    private genreMovieEnum genre;

    private Date release_date;

}

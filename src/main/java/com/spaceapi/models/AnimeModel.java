package com.spaceapi.models;

import com.spaceapi.ENUMS.genreMovieEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
    @NotNull
    private String studio;
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

}

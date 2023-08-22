package com.spaceapi.models;

import com.spaceapi.ENUMS.genreMovieEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public abstract class MidiaModel {
    @NotNull
    public String coverImage;
    @NotNull
    public String title;
    @NotNull
    public String image;
    @NotNull
    public String synopsis;
    @NotNull
    public genreMovieEnum genre;
    @NotNull
    public Date release_date;

}

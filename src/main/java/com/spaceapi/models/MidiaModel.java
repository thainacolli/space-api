package com.spaceapi.models;

import com.spaceapi.ENUMS.genreMovieEnum;
import lombok.Data;

import java.util.Date;

@Data
public class MidiaModel {
    private String coverImage;
    private String title;
    private String image;
    private String synopsis;
    private genreMovieEnum genre;
    private Date release_date;

}

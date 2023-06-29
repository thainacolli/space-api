package com.spaceapi.models;

import lombok.Data;

import java.util.Date;

@Data
public class MidiaModel {
    String coverImage;
    String title;
    String image;
    String synopsis;
    Enum<GenreModel> genre;
    Date release_date;

}

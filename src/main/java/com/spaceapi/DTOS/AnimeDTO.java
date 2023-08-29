package com.spaceapi.DTOS;

import com.spaceapi.ENUMS.genreMovieEnum;

import java.util.Date;

public record AnimeDTO(String title,
                       String coverImage,
                       String image,
                       Integer durationMinutes,
                       Date release_date,
                       String synopsis,
                       Integer epQt,
                       genreMovieEnum genreMovie,
                       String studio,
                       Integer seasonQt) {
}

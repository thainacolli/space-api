package com.spaceapi.DTOS;

import com.spaceapi.ENUMS.genreMovieEnum;
import com.spaceapi.models.UsuarioModel;

import java.util.Date;
import java.util.List;

public record MovieDTO(
        String title,
        String coverImage,
        String image,
        Integer durationMinutes,
        Date release_date,
        String synopsis,

        genreMovieEnum genreMovie) {
}

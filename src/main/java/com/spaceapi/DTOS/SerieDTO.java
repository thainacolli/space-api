package com.spaceapi.DTOS;

import com.spaceapi.models.MidiaModel;
import com.spaceapi.models.UserModel;

import java.util.List;

public record SerieDTO(
        Integer epQtd,

        Integer seasonQtd,

        List<UserModel> userId,

        List<MidiaModel> midiaId) {
}

package com.spaceapi.DTOS;

import com.spaceapi.models.MidiaModel;
import com.spaceapi.models.UsuarioModel;

import java.util.List;

public record SerieDTO(
        Integer epQtd,

        Integer seasonQtd,

        List<UsuarioModel> userId,

        List<MidiaModel> midiaId) {
}

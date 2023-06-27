package com.spaceapi.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "animes")
public class AnimeModel extends MidiaModel{
    @Id
    String id;
    String studio;
    Integer epQt;
    Integer seasonQt;
    List<UsuarioModel> usuarioId;
}

package com.spaceapi.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "series")
public class SerieModel extends MidiaModel {
    @Id
    String id;
    Integer epQt;
    Integer seasonQt;
    List<UsuarioModel> usuarioId;
}

package com.spaceapi.models;


import com.spaceapi.DTOS.SerieDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "series")
public class SerieModel  {
    @Id
    String id;
    Integer epQt;
    Integer seasonQt;
    List<UsuarioModel> userId;

    List<MidiaModel> midiaId;

    public SerieModel(SerieDTO serie) {
        this.epQt = serie.epQtd();
        this.seasonQt = serie.seasonQtd();
        this.userId = serie.userId();
        this.midiaId = serie.midiaId();
    }


    public SerieModel() {
    }
}

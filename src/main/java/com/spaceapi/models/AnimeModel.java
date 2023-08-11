package com.spaceapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Table(name="animes")
@Entity
@Data
public class AnimeModel extends MidiaModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studio;
    private Integer epQt;
    private Integer seasonQt;
    private List<UsuarioModel> usuarioId;
}

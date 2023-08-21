package com.spaceapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.*;

import java.util.List;

@Table(name="series")
@Entity
@Data
public class SerieModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer epQt;
    private Integer seasonQt;

}

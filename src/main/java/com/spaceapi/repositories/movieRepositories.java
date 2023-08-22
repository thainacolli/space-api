package com.spaceapi.repositories;

import com.spaceapi.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface movieRepositories extends JpaRepository<MovieModel,Long> {
    public MovieModel save(MovieModel MovieModel);
}

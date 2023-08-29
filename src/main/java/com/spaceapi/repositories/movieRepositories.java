package com.spaceapi.repositories;

import com.spaceapi.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface movieRepositories extends JpaRepository<MovieModel,Long> {
    public MovieModel save(MovieModel MovieModel);
}

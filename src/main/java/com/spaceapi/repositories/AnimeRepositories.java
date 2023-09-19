package com.spaceapi.repositories;

import com.spaceapi.models.AnimeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepositories extends JpaRepository<AnimeModel,Long> {
}

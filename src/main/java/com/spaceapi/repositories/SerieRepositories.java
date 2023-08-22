package com.spaceapi.repositories;

import com.spaceapi.models.SerieModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SerieRepositories extends MongoRepository<SerieModel, String> {
}

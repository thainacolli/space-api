package com.spaceapi.repositories;

import com.spaceapi.models.MovieModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface movieRepositories extends MongoRepository<MovieModel,String> {

}

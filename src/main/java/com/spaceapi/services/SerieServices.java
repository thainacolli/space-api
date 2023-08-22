package com.spaceapi.services;


import com.spaceapi.models.SerieModel;
import com.spaceapi.repositories.SerieRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieServices {

//    private final SerieRepositories repositories;
//
//    @Autowired
//    public SerieServices(SerieRepositories repositories) {
//        this.repositories = repositories;
//    }
//

    @Autowired
    SerieRepositories repositories;


    public void SaveSerie(SerieModel serie) {
        repositories.save(serie);
    }
}

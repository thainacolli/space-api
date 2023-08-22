package com.spaceapi.controllers;


import com.spaceapi.DTOS.SerieDTO;
import com.spaceapi.models.SerieModel;
import com.spaceapi.services.SerieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieController {



    @Autowired
    SerieServices services;


    @PostMapping("/addSerie")
    public ResponseEntity createSerie(@RequestBody SerieDTO serie) {
        try {
            var newSerie = new SerieModel(serie);
            services.SaveSerie(newSerie);
            return ResponseEntity.ok("Serie created successfully");
        } catch (Error e) {
            return ResponseEntity.status(500).body("Serie not created Error : " + e);
        }
    }
}

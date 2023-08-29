package com.spaceapi.controllers;

import com.spaceapi.DTOS.AnimeDTO;
import com.spaceapi.DTOS.MovieDTO;
import com.spaceapi.models.AnimeModel;
import com.spaceapi.repositories.AnimeRepositories;
import com.spaceapi.services.AnimeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("animes")
@CrossOrigin("*")
public class AnimesController {

    @Autowired
    private AnimeServices services;
    @PostMapping("/addAnime")
    public ResponseEntity createAnime(@RequestBody AnimeDTO anime){
        ResponseEntity response = services.saveAnime(anime);
        return response;
    }

    @GetMapping("/list")
    public ResponseEntity getAllAnime(){
        try{
            var animes = services.getAllAnime();
            return ResponseEntity.ok(animes);
        }catch(Error e){
            return ResponseEntity.status(400).body("Any Movie available");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAnimeById(@PathVariable Long id){
        return services.deleteAnimeById(id);
    }


    @GetMapping("{id}")
    public ResponseEntity getAnimeById(@PathVariable Long id){
        return services.getAnimeById(id);
    }

    @PutMapping("/edit")
    public ResponseEntity editAnime(@RequestBody AnimeModel anime){
        return services.editAnime(anime);
    }



}

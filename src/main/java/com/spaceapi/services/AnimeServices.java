package com.spaceapi.services;

import com.spaceapi.DTOS.AnimeDTO;
import com.spaceapi.DTOS.MovieDTO;
import com.spaceapi.models.AnimeModel;
import com.spaceapi.models.MovieModel;
import com.spaceapi.models.UserModel;
import com.spaceapi.repositories.AnimeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeServices {

    @Autowired
    private AnimeRepositories repository;

    @Autowired
    private UserServices userServices;

    public ResponseEntity saveAnime(AnimeDTO anime) {
        try {
            AnimeModel newAnime = new AnimeModel();
            newAnime.setTitle(anime.title());
            newAnime.setSynopsis(anime.synopsis());
            newAnime.setStudio(anime.studio());
            newAnime.setEpQt(anime.seasonQt());
            newAnime.setCoverImage(anime.coverImage());
            newAnime.setRelease_date(anime.release_date());
            newAnime.setImage(anime.image());
            newAnime.setGenre(anime.genreMovie());
            newAnime.setSeasonQt(anime.seasonQt());

            UserModel user = userServices.findById(anime.user());
            newAnime.setUser(user);

            Optional<AnimeModel> animeResult = Optional.ofNullable(repository.save(newAnime));

            if (animeResult.isPresent()) {
                return ResponseEntity.status(200).body(animeResult);
            } else {
                return ResponseEntity.status(500).body(animeResult);
            }

        } catch (Error e) {
            return ResponseEntity.status(500).body(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimeModel> getAnimeById(@PathVariable Long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    public List<AnimeModel> getAllAnime(){
        return repository.findAll();
    }

    public ResponseEntity deleteAnimeById(Long id){
        try {
            Optional<AnimeModel> anime = repository.findById(id);

            if (anime.isPresent()) {
                repository.deleteById(id);
                return ResponseEntity.status(200).body("Anime deleted successfully");
            } else {
                return ResponseEntity.status(404).body("Anime not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting anime");
        }
    }

    public ResponseEntity editAnime(AnimeModel anime){
        try{
            Optional<AnimeModel> animeCreated = Optional.ofNullable(repository.save(anime));
            if(animeCreated.isPresent()){
                return ResponseEntity.status(200).body(animeCreated);
            }else{
                return ResponseEntity.status(400).body("This anime is not available");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error on editing anime : " + anime.getTitle());
        }
    }

    }

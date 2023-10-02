package com.spaceapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spaceapi.DTOS.MovieDTO;
import com.spaceapi.ENUMS.genreMovieEnum;
import com.spaceapi.controllers.movieController;
import com.spaceapi.models.GenreModel;
import com.spaceapi.models.MovieModel;
import com.spaceapi.repositories.movieRepositories;
import com.spaceapi.services.movieServices;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class movieControllerTest {

    @InjectMocks
    private movieController movieController;

    @Mock
    private movieServices movieServices;

    @Autowired
    private MockMvc mockMvc;

    public movieControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void ShoudlcreateAMovie() throws Exception{

        var movie = new MovieModel();

        movie.setDurationMinutes(124);
        movie.setImage("link");
        movie.setGenre(genreMovieEnum.TERROR);
        movie.setTitle("movie thriller");
        movie.setSynopsis("This is a terror movie very scary");
        movie.setCoverImage("link");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date releaseDate = dateFormat.parse("2023-08-21");

        movie.setRelease_date(releaseDate);

      when(movieServices.SaveMovie(any(MovieDTO.class))
      ).thenReturn(ResponseEntity.status(201).body(movie));

        // Execução do teste
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/addMovie")
                        .content(asJsonString(movie))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())

                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(movie.getTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genreMovie").value(movie.getGenre()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.coverImage").value(movie.getCoverImage()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.image").value(movie.getImage()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.durationMinutes").value(movie.getDurationMinutes()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.release_date").value(movie.getRelease_date()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.synopsis").value(movie.getSynopsis()));
        // Add more assertions for other properties if needed
    }

    // Helper method to convert an object to JSON string
    private String asJsonString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
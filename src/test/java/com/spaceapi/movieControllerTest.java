package com.spaceapi;

import com.spaceapi.controllers.movieController;
import com.spaceapi.models.GenreModel;
import com.spaceapi.models.MovieModel;
import com.spaceapi.repositories.movieRepositories;
import com.spaceapi.services.movieServices;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class movieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private movieServices movieServices;

    @InjectMocks
    private movieController moviecontroller;

    @Test
    public void ShoudlcreateAMovie() throws Exception{

        var movie = new MovieModel();
        LocalDate localDate = LocalDate.now();

        Date date = Date.from(Instant.from(localDate));
        movie.setDurationMinutes(124);
        movie.setImage("link");
        movie.setGenre(GenreModel.TERROR);
        movie.setRelease_date(date);
        movie.setTitle("movie thriller");
        movie.setSynopsis("This is a terror movie very scary");
        movie.setCoverImage("link");

//        // Configuração do comportamento esperado do repositório mockado
//        when(movieServices.SaveMovie(any(movie.class));).thenReturn(movie);

        // Execução do teste
        mockMvc.perform(MockMvcRequestBuilders.post("/movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Example Product\", \"price\": 10.99}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Example Product"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(10.99));
    }
}

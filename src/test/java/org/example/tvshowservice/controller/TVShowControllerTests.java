package org.example.tvshowservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.tvshowservice.utils.TestDataUtils;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TVShowControllerTests {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private TestDataUtils testDataUtils;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String AUTHENTICATION_VALID = "Basic a3Jpc2huYTprcmlzaG5h";
    private static final String AUTHENTICATION_INVALID = "Basic a3Jpc2huYTprcmlzaG5h9";

    private static final String INVALID_SHOWID = "6e991888-daa0-4d3c-ad6a-317f1fe06ffc";
    private static final String INVALID_GENRE = "CrimeCom";


    @Test
    @Order(1)
    void saveTVShowSuccessful() throws Exception {

        this.mockMvc.perform(post("/v1/tv/shows")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, AUTHENTICATION_VALID)
                        .content(OBJECT_MAPPER.writeValueAsString(TestDataUtils.createTVShowData()))
                ).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

    @Test
    @Order(2)
    void getAllTVShowSuccessful() throws Exception {

        this.mockMvc.perform(get("/v1/tv/shows")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, AUTHENTICATION_VALID)
                ).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

    @Test
    @Order(3)
    void getAllTVShowInvalidCredentials() throws Exception {

        this.mockMvc.perform(get("/v1/tv/shows")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, AUTHENTICATION_INVALID)
                ).andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();
    }


    @Test
    @Order(4)
    void getTVShowByIDSuccessful() throws Exception {


        var showId = testDataUtils.showId();

        this.mockMvc.perform(get("/v1/tv/shows/{showId}", showId.getShowId())
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, AUTHENTICATION_VALID)
                ).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

    @Test
    @Order(5)
    void getTVShowByIDInvalidShowId() throws Exception {

        this.mockMvc.perform(get("/v1/tv/shows/{showId}", INVALID_SHOWID)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, AUTHENTICATION_VALID)
                ).andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();
    }

    @Test
    @Order(6)
    void getTVShowByGenreSuccessful() throws Exception {


        String genre = testDataUtils.showByShowId(testDataUtils.showId().getShowId()).getGenre();

        this.mockMvc.perform(get("/v1/tv/shows/genre/{genre}", genre)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, AUTHENTICATION_VALID)
                ).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

    @Test
    @Order(7)
    void getTVShowByInvalidGenre() throws Exception {

        this.mockMvc.perform(get("/v1/tv/shows/genre/{genre}", INVALID_GENRE)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, AUTHENTICATION_VALID)
                ).andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();
    }

    @Test
    @Order(8)
    void updateTVShow() throws Exception {


        var showId = testDataUtils.showId();

        this.mockMvc.perform(put("/v1/tv/shows/{showId}", showId.getShowId())
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, AUTHENTICATION_VALID)
                        .content(OBJECT_MAPPER.writeValueAsString(TestDataUtils.updateTVShowData()))
                ).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

    @Test
    @Order(9)
    void deleteTVShow() throws Exception {


        var showId = testDataUtils.showId();

        this.mockMvc.perform(delete("/v1/tv/shows/{showId}", showId.getShowId())
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.AUTHORIZATION, AUTHENTICATION_VALID)
                ).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }
}

package org.example.tvshowservice.service;

import org.example.tvshowservice.utils.TestDataUtils;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TVShowServiceTests {

    @Autowired
    private TVShowService tvShowService;

    @Autowired
    private TestDataUtils testData;

    private static final String GENRE = "Comedy";


    @Test
    @Order(1)
    void saveTVShowTest() {
        var tvShow = tvShowService.saveTVShow(TestDataUtils.createTVShowData());
        assertEquals("Comedy", testData.showByShowId(testData.showId().getShowId()).getGenre());
        assertEquals("English", testData.showByShowId(testData.showId().getShowId()).getLanguage());
    }

    @Test
    @Order(2)
    void getAllTVShowTest() {
        var response = tvShowService.getAllTVShow();
        assertEquals("Comedy", response.get(0).getGenre());
        assertEquals("English", response.get(0).getLanguage());
    }

    @Test
    @Order(3)
    void getTVShowByIdTest() {
        var response = tvShowService.getTVShowByID(testData.showId().getShowId());
        assertEquals("Comedy", response.getGenre());
        assertEquals("English", response.getLanguage());
        assertEquals("Friends", response.getTitle());
    }

    @Test
    @Order(4)
    void getTVShowBYGenreTest() {
        var response = tvShowService.getTVShowByGenre(GENRE);
        assertEquals("Comedy", response.get(0).getGenre());
    }

    @Test
    @Order(5)
    void updateTVShowTest() {
        var response = tvShowService.updateTVShow(TestDataUtils.updateTVShowData(), testData.showId().getShowId());
        assertEquals("French", response.getLanguage());
        assertEquals("America", response.getCountry());
        assertEquals(2001, response.getReleaseYear());
    }
}

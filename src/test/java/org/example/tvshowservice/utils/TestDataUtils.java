package org.example.tvshowservice.utils;

import org.example.tvshowservice.model.TVShowCreationRequestDomain;
import org.example.tvshowservice.model.db.TVShow;
import org.example.tvshowservice.model.inbound.TVShowCreationResponse;
import org.example.tvshowservice.service.TVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestDataUtils {

    @Autowired
    private TVShowService tvShowService;

    public static TVShowCreationRequestDomain createTVShowData() {
        TVShowCreationRequestDomain tvShow = new TVShowCreationRequestDomain();
        tvShow.setTitle("Friends");
        tvShow.setGenre("Comedy");
        tvShow.setDuration("2h 10m");
        tvShow.setCountry("United States");
        tvShow.setLanguage("English");
        tvShow.setDescription("Six friends living in New York city");
        tvShow.setRating(5.6F);
        tvShow.setImageURL("https://images.app.goo.gl/iYiG99TgmBhwjF2VA");
        tvShow.setTrailerURL("https://www.youtube.com/watch?v=IEEbUzffzrk&ab_channel=WS");
        tvShow.setReleaseYear(1994);
        return tvShow;
    }

    public static TVShowCreationRequestDomain updateTVShowData() {
        TVShowCreationRequestDomain tvShow = new TVShowCreationRequestDomain();

        tvShow.setGenre("Romantic");
        tvShow.setDuration("3h 25m");
        tvShow.setCountry("America");
        tvShow.setLanguage("French");
        tvShow.setRating(3.4F);
        tvShow.setReleaseYear(2001);
        return tvShow;
    }

    public TVShowCreationResponse showId() {
        return tvShowService.saveTVShow(createTVShowData());
    }

    public TVShow showByShowId(String showId) {
        return tvShowService.getTVShowByID(showId);
    }
}

package org.example.tvshowservice.service;

import org.example.tvshowservice.model.TVShowCreationRequestDomain;
import org.example.tvshowservice.model.db.TVShow;
import org.example.tvshowservice.model.inbound.TVShowCreationResponse;

import java.util.List;

public interface TVShowService {

    TVShowCreationResponse saveTVShow(TVShowCreationRequestDomain tvShowCreationRequestDomain);

    List<TVShow> getAllTVShow();

    TVShow getTVShowByID(String showId);

    List<TVShow> getTVShowByGenre(String genre);

    TVShow updateTVShow(TVShowCreationRequestDomain tvShowCreationRequestDomain, String showId);

    void deleteTVShow(String showId);

}

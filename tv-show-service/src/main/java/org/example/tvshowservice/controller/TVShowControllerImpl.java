package org.example.tvshowservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.tvshowservice.model.TVShowCreationRequestDomain;
import org.example.tvshowservice.model.db.TVShow;
import org.example.tvshowservice.model.inbound.TVShowController;
import org.example.tvshowservice.model.inbound.TVShowCreationResponse;
import org.example.tvshowservice.service.TVShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/tv/shows", produces = "application/json")

public class TVShowControllerImpl implements TVShowController {

    private final TVShowService tvShowService;

    @Override
    public ResponseEntity<TVShowCreationResponse> saveTVShow(@RequestBody TVShowCreationRequestDomain tvShowCreationRequestDomain) {
        var response = tvShowService.saveTVShow(tvShowCreationRequestDomain);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getAllTVShow() {
        return new ResponseEntity<>(tvShowService.getAllTVShow(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TVShow> getTVShowByID(@PathVariable String showId) {
        return new ResponseEntity<>(tvShowService.getTVShowByID(showId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getTVShowByGenre(@PathVariable String genre) {
        return new ResponseEntity<>(tvShowService.getTVShowByGenre(genre), HttpStatus.OK);
    }

    @Override
    public <T> ResponseEntity<T> updateTVShow(@RequestBody TVShowCreationRequestDomain tvShowCreationRequestDomain, @PathVariable String showId) {

        tvShowService.updateTVShow(tvShowCreationRequestDomain, showId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override

    public <T> ResponseEntity<T> deleteTVShow(@PathVariable String showId) {
        tvShowService.deleteTVShow(showId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

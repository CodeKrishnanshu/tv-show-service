package org.example.tvshowservice.util;

import lombok.NoArgsConstructor;
import org.example.tvshowservice.model.TVShowCreationRequestDomain;
import org.example.tvshowservice.model.db.TVShow;

import java.util.UUID;

@NoArgsConstructor
public class DomainEntityMapping {

    public static TVShow domain2entity(TVShowCreationRequestDomain showReq) {
        TVShow tvShow = new TVShow();

        tvShow.setTitle(showReq.getTitle());
        tvShow.setCountry(showReq.getCountry());
        tvShow.setDescription(showReq.getDescription());
        tvShow.setGenre(showReq.getGenre());
        tvShow.setLanguage(showReq.getLanguage());
        tvShow.setDuration(showReq.getDuration());
        tvShow.setRating(showReq.getRating());
        tvShow.setShowId(UUID.randomUUID().toString());
        tvShow.setTrailerURL(showReq.getTrailerURL());
        tvShow.setImageURL(showReq.getImageURL());
        tvShow.setReleaseYear(showReq.getReleaseYear());
        return tvShow;
    }

}

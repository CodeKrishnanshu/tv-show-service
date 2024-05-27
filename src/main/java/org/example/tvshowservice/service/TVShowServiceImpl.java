package org.example.tvshowservice.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.example.tvshowservice.exceptions.InternalServerErrorException;
import org.example.tvshowservice.exceptions.NotFoundRequestException;
import org.example.tvshowservice.model.TVShowCreationRequestDomain;
import org.example.tvshowservice.model.db.TVShow;
import org.example.tvshowservice.model.inbound.TVShowCreationResponse;
import org.example.tvshowservice.repository.TVShowRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

import static org.example.tvshowservice.util.DomainEntityMapping.domain2entity;

@Service
@RequiredArgsConstructor
public class TVShowServiceImpl implements TVShowService {

    private final TVShowRepository tvShowRepository;


    @Override
    public TVShowCreationResponse saveTVShow(TVShowCreationRequestDomain tvShowCreationRequestDomain) {
        TVShow tvShow = domain2entity(tvShowCreationRequestDomain);
        return new TVShowCreationResponse(tvShowRepository.save(tvShow).getShowId());
    }

    @Override
    public List<TVShow> getAllTVShow() {
        var response = tvShowRepository.findAll();
        if (ObjectUtils.isEmpty(response)) {
            try {
                throw new NotFoundRequestException("Not Found");
            } catch (NotFoundRequestException e) {
                throw new InternalServerErrorException(String.valueOf(e));
            }
        }
        return response;
    }

    @Override
    public TVShow getTVShowByID(String showId) {
        return findShowById(showId);
    }

    @Override
    public List<TVShow> getTVShowByGenre(String genre) {
        var tvShows = tvShowRepository.findByGenre(genre);
        if (ObjectUtils.isEmpty(tvShows)) {
            throw new NotFoundRequestException("Not Found");
        }
        return tvShows;
    }

    @Override
    public TVShow updateTVShow(TVShowCreationRequestDomain tvShowCreationRequestDomain, String showId) {
        var existingShow = findShowById(showId);

        if (!StringUtils.isEmpty(tvShowCreationRequestDomain.getTitle())) {
            existingShow.setTitle(tvShowCreationRequestDomain.getTitle());
        }
        if (!StringUtils.isEmpty(tvShowCreationRequestDomain.getGenre())) {
            existingShow.setGenre(tvShowCreationRequestDomain.getGenre());
        }
        if (!ObjectUtils.isEmpty(tvShowCreationRequestDomain.getReleaseYear())) {
            existingShow.setReleaseYear((tvShowCreationRequestDomain.getReleaseYear()));
        }
        if (!StringUtils.isEmpty(tvShowCreationRequestDomain.getLanguage())) {
            existingShow.setLanguage(tvShowCreationRequestDomain.getLanguage());
        }

        if (!StringUtils.isEmpty(tvShowCreationRequestDomain.getDescription())) {
            existingShow.setDescription(tvShowCreationRequestDomain.getDescription());
        }

        if (!StringUtils.isEmpty(tvShowCreationRequestDomain.getCountry())) {
            existingShow.setCountry(tvShowCreationRequestDomain.getCountry());
        }
        if (!ObjectUtils.isEmpty(tvShowCreationRequestDomain.getRating())) {
            existingShow.setRating(tvShowCreationRequestDomain.getRating());
        }

        if (!StringUtils.isEmpty(tvShowCreationRequestDomain.getDuration())) {
            existingShow.setDuration(tvShowCreationRequestDomain.getDuration());
        }
        if (!StringUtils.isEmpty(tvShowCreationRequestDomain.getDuration())) {
            existingShow.setDuration(tvShowCreationRequestDomain.getDuration());
        }
        if (!StringUtils.isEmpty(tvShowCreationRequestDomain.getImageURL())) {
            existingShow.setImageURL(tvShowCreationRequestDomain.getImageURL());
        }
        if (!StringUtils.isEmpty(tvShowCreationRequestDomain.getTrailerURL())) {
            existingShow.setTrailerURL(tvShowCreationRequestDomain.getTrailerURL());
        }
        return tvShowRepository.save(existingShow);
    }

    @Override
    public void deleteTVShow(String showId) {
        findShowById(showId);
        tvShowRepository.deleteByShowId(showId);
    }

    protected TVShow findShowById(String showId) {
        var tvShow = tvShowRepository.findByShowId(showId);
        if (ObjectUtils.isEmpty(tvShow)) {
            throw new NotFoundRequestException("Not Found");
        }
        return tvShow;
    }

}

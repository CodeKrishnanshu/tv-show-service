package org.example.tvshowservice.repository;

import jakarta.transaction.Transactional;
import org.example.tvshowservice.model.db.TVShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TVShowRepository extends JpaRepository<TVShow, Integer> {
    List<TVShow> findByGenre(@Param("genre") String genre);

    TVShow findByShowId(@Param("showId") String showId);

    @Transactional
    void deleteByShowId(@Param("showId") String showId);


}

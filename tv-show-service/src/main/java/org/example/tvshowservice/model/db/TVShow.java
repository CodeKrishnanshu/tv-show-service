package org.example.tvshowservice.model.db;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TV_SHOW")
@NoArgsConstructor
@Data
public class TVShow {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SHOW_ID", nullable = false)
    @Schema(description = "Unique ID for show", example = "7029eba7-bfd1-48ca-a436-e745b9868fd1")
    private String showId;

    @Column(name = "SHOW-TITLE", nullable = false)
    @Schema(description = "The title of the show", required = true, example = "Friends")
    private String title;

    @Column(name = "GENRE", nullable = false)
    @Schema(description = "Genre of the show", required = true, example = "Comedy")
    private String genre;

    @Column(name = "RELEASE_YEAR")
    @Schema(description = "Release year of the show", example = "2024")
    private Integer releaseYear;

    @Column(name = "LANGUAGE")
    @Schema(description = "Language of the show", example = "English")
    private String language;

    @Column(name = "DESCRIPTION")
    @Schema(description = "Description of the show", example = "Six American friends living in a house")
    private String description;

    @Column(name = "COUNTRY")
    @Schema(description = "Country of origin of TV show", example = "United States")
    private String country;

    @Column(name = "RATING")
    @Schema(description = "Rating of TV show", example = "4.6")
    private Float rating;

    @Column(name = "DURATION")
    @Schema(description = "Duration of TV show", example = "2h 10m")
    private String duration;

    @Column(name = "IMAGE")
    @Schema(description = "URL of the image of TV show", example = "https://images.app.goo.gl/iYiG99TgmBhwjF2VA")
    private String imageURL;

    @Column(name = "TRAILER")
    @Schema(description = "URL of the trailer of TV show", example = "https://www.youtube.com/watch?v=IEEbUzffzrk&ab_channel=WS")
    private String trailerURL;

}

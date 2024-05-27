package org.example.tvshowservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Builder
public class TVShowCreationRequestDomain {

    @Schema(description = "The title of the show", required = true, example = "Friends")
    private String title;

    @Schema(description = "Genre of the show", required = true, example = "Comedy")
    private String genre;

    @Schema(description = "Release year of the show", example = "2024")
    private Integer releaseYear;

    @Schema(description = "Language of the show", example = "English")
    private String language;

    @Schema(description = "Description of the show", example = "Six American friends living in a house")
    private String description;

    @Schema(description = "Country of origin of TV show", example = "United States")
    private String country;

    @Schema(description = "Rating of TV show", example = "4.6")
    private Float rating;

    @Schema(description = "Duration of TV show", example = "2h 10m")
    private String duration;

    @Schema(description = "URL of the image of TV show", example = "https://images.app.goo.gl/iYiG99TgmBhwjF2VA")
    private String imageURL;

    @Schema(description = "URL of the trailer of TV show", example = "https://www.youtube.com/watch?v=IEEbUzffzrk&ab_channel=WS")
    private String trailerURL;
}

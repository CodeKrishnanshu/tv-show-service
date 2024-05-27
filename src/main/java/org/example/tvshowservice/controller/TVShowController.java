package org.example.tvshowservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.tvshowservice.exceptions.InternalServerErrorException;
import org.example.tvshowservice.exceptions.NotFoundRequestException;
import org.example.tvshowservice.model.TVShowCreationRequestDomain;
import org.example.tvshowservice.model.db.TVShow;
import org.example.tvshowservice.model.inbound.TVShowCreationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "TV Shows API", description = "TV Shows management service")
public interface TVShowController {


    @Operation(
            description = "Create new tv show",
            responses = {
                    @ApiResponse(responseCode = "201", description = "TV show created successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TVShowCreationResponse.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = NotFoundRequestException.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerErrorException.class))
                    })
            })
    @PostMapping(
            produces = {"application/json"},
            consumes = {"application/json"})
    default ResponseEntity<TVShowCreationResponse> saveTVShow(@RequestBody TVShowCreationRequestDomain tvShowCreationRequestDomain) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping
    @Operation(
            description = "Retrieving all TV shows",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Tv shows retrieved successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TVShow.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = NotFoundRequestException.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerErrorException.class))
                    })
            })
    default ResponseEntity<Object> getAllTVShow() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            description = "Retrieve TV show details by Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "TV Show retrieved successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TVShow.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = NotFoundRequestException.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerErrorException.class))
                    })
            })
    @GetMapping("/{showId}")
    default ResponseEntity<TVShow> getTVShowByID(@PathVariable String showId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            description = "Retrieve TV shows by Genre",
            responses = {
                    @ApiResponse(responseCode = "200", description = "TV Shows retrieved successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TVShow.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = NotFoundRequestException.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerErrorException.class))
                    })
            })
    @GetMapping("/genre/{genre}")
    default ResponseEntity<Object> getTVShowByGenre(@PathVariable String genre) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            description = "Update existing TV show",
            responses = {
                    @ApiResponse(responseCode = "200", description = "TV Show updated successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TVShow.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = NotFoundRequestException.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerErrorException.class))
                    })
            })
    @PutMapping("/{showId}")
    default <T> ResponseEntity<T> updateTVShow(
            @RequestBody TVShowCreationRequestDomain tvShowCreationRequestDomain, @PathVariable String showId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            description = "Delete TV Show by Id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "TV show deleted successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TVShow.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = NotFoundRequestException.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = InternalServerErrorException.class))
                    })
            })

    @DeleteMapping("/{showId}")
    default <T> ResponseEntity<T> deleteTVShow(@PathVariable String showId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

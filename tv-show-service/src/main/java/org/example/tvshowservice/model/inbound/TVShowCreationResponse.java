package org.example.tvshowservice.model.inbound;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TVShowCreationResponse {
    @Schema(description = "Unique ID for show", example = "7029eba7-bfd1-48ca-a436-e745b9868fd1")
    private String showId;
}

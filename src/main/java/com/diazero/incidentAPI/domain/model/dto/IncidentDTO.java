package com.diazero.incidentAPI.domain.model.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Getter
@Setter
public class IncidentDTO {
    @ApiModelProperty(notes = "Incident id", example = "1", required = true)
    private String idIncident;
    @ApiModelProperty(notes = "Incident title", example = "Machine problem example", required = true)
    private String name;
    @ApiModelProperty(notes = "Incident description", example = "laptop softwares malfunction", required = true)
    private String description;
    @ApiModelProperty(notes = "Creation date", example = "100", required = true)
    private OffsetDateTime createdAt;
    @ApiModelProperty(notes = "Date of last modification", example = "6.9", required = true)
    private OffsetDateTime updatedAt;
    @ApiModelProperty(notes = "", example = "2023-10-31", required = true)
    private OffsetDateTime closedAt;
}

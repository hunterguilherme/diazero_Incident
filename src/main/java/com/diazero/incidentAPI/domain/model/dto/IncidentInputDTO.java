package com.diazero.incidentAPI.domain.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidentInputDTO {

    @ApiModelProperty(notes = "Incident title", example = "Machine problem example", required = true)
    private String name;
    @ApiModelProperty(notes = "Incident description", example = "laptop softwares malfunction", required = true)
    private String description;
}

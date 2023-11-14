package com.diazero.incidentAPI.modelmapper;

import com.diazero.incidentAPI.domain.model.Incident;
import com.diazero.incidentAPI.domain.model.dto.IncidentDTO;
import com.diazero.incidentAPI.domain.model.dto.IncidentInputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.createTypeMap(IncidentInputDTO.class, Incident.class);
        modelMapper.createTypeMap(Incident.class, IncidentDTO.class);
        return modelMapper;
    }


}
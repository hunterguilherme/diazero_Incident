package com.diazero.incidentAPI.domain.service;

import com.diazero.incidentAPI.domain.model.dto.IncidentDTO;
import com.diazero.incidentAPI.domain.model.dto.IncidentInputDTO;

import java.util.List;

public interface IncidentService {

    IncidentDTO createIncident(IncidentInputDTO incidentDTO);
    IncidentDTO updateIncident(Long id, IncidentInputDTO incidentDTO);
    void removeIncident(Long id);
    List<IncidentDTO> getAllIncidents();

    IncidentDTO getIncidentById(Long id);
    List<IncidentDTO> getLastTwentyIncidents();


}

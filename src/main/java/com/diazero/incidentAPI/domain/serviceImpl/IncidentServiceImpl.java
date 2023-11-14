package com.diazero.incidentAPI.domain.serviceImpl;

import com.diazero.incidentAPI.domain.exceptions.EntityNotFoundException;
import com.diazero.incidentAPI.domain.model.Incident;
import com.diazero.incidentAPI.domain.model.dto.IncidentDTO;
import com.diazero.incidentAPI.domain.model.dto.IncidentInputDTO;
import com.diazero.incidentAPI.domain.repository.IncidentRepository;
import com.diazero.incidentAPI.domain.service.IncidentService;
import com.diazero.incidentAPI.modelmapper.InputToEntityIncident;
import com.diazero.incidentAPI.modelmapper.EntityToOutputIncident;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class IncidentServiceImpl implements IncidentService {
    private static final String NOT_FOUND = "Incident not found, verify ID";

    @Autowired
    private IncidentRepository incidentRepository;
    @Autowired
    private EntityToOutputIncident entityToOutputIncident;

    @Autowired
    private InputToEntityIncident inputToEntityIncident;

    @Override
    @Transactional
    public IncidentDTO createIncident(IncidentInputDTO incidentInputDTO) {

        Incident incident = inputToEntityIncident.toDomainObject(incidentInputDTO);

        incident.setCreatedAt(OffsetDateTime.now());
        incident.setUpdatedAt(OffsetDateTime.now());
        incident = incidentRepository.save(incident);

        IncidentDTO incidentOutputDTO = entityToOutputIncident.toModel(incident);
        return incidentOutputDTO;
    }

    @Override
    public IncidentDTO updateIncident(Long id, IncidentInputDTO updatedIncident) {

        Incident currentIncident = searchOrFail(id);

        BeanUtils.copyProperties(updatedIncident, currentIncident, "id", "createdAt");
        currentIncident.setUpdatedAt(OffsetDateTime.now());
        incidentRepository.save(currentIncident);

        IncidentDTO incidentOutputDTO = entityToOutputIncident.toModel(currentIncident);
        return incidentOutputDTO;
    }

    @Override
    public void removeIncident(Long id) {
        Incident incident = searchOrFail(id);
        incidentRepository.delete(incident);
    }

    @Override
    public List<IncidentDTO> getAllIncidents() {
        List<Incident> incidents = incidentRepository.findAll();
        List<IncidentDTO> incidentOutput = entityToOutputIncident.toCollectionModel(incidents);
        return incidentOutput;
    }

    @Override
    public IncidentDTO getIncidentById(Long id) {
        Incident incident = searchOrFail(id);
        IncidentDTO incidentOutput = entityToOutputIncident.toModel(incident);
        return incidentOutput;
    }

    @Override
    public List<IncidentDTO> getLastTwentyIncidents() {
        List<Incident> incidents = incidentRepository.findTop20ByOrderByCreatedAtDesc();
        List<IncidentDTO> incidentsOutput = entityToOutputIncident.toCollectionModel(incidents);
        return incidentsOutput;

    }

    public Incident searchOrFail(Long id) {
        return incidentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_FOUND));
    }
}
